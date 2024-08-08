val projectVersion: String by project

group = "com.fingerprint"
version = projectVersion

plugins {
    alias(libs.plugins.openapi.generator)
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    mavenCentral()
}

publishing {
    publications {
        register("localMavenJava", MavenPublication::class) {
            groupId = "com.fingerprint"
            artifactId = "fingerprint-pro-server-api-sdk"
            version = projectVersion
            from(components["java"])
        }
    }
}

dependencies {
    implementation(libs.swagger.annotations)
    api(libs.jersey.client)
    api(libs.jersey.hk2)
    api(libs.jersey.media.json)
    api(libs.jersey.media.multipart)
    api(libs.jersey.apache.connector)
    api(libs.jackson.core)
    api(libs.jackson.annotations)
    api(libs.jackson.databind)
    api(libs.jackson.databind.nullable)
    api(libs.jackson.jsr310)
    api(libs.jakarta.annotation.api)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.mockito)
}

sourceSets {
    main {
        java {
            srcDir("src/main/java")
        }
    }
}

openApiGenerate {
    generatorName.set("java")
    inputSpec.set("$rootDir/res/fingerprint-server-api.yaml")
    outputDir.set(layout.buildDirectory.dir("generated").get().asFile.path)
    groupId.set("com.fingerprint")
    id.set("fingerprint-pro-server-api-sdk")
    version.set(projectVersion)
    apiPackage.set("com.fingerprint.api")
    modelPackage.set("com.fingerprint.model")
    invokerPackage.set("com.fingerprint.sdk")
    library.set("jersey3")
    templateDir.set("$rootDir/template")

    gitHost.set("github.com")
    gitRepoId.set("fingerprint-pro-server-api-java-sdk")
    gitUserId.set("fingerprintjs")
    configOptions.put("hideGenerationTimestamp", "true")
}

tasks.register("removeDocs") {
    doLast {
        fileTree("$rootDir/docs").files
            .filter { it.isFile && it.name != "DecryptionKey.md" && it.name != "Sealed.md" }
            .forEach {
                it.delete()
            }
    }
}

tasks.register("removeClasses") {
    doLast {
        File("$rootDir/sdk/src/main/java/com/fingerprint/model").deleteRecursively()
        File("$rootDir/sdk/src/main/java/com/fingerprint/api").deleteRecursively()
    }
}

tasks.register<Copy>("copyDocs") {
    from(layout.buildDirectory.dir("generated/docs"))
    into("$rootDir/docs")
}

tasks.register<Copy>("copyClasses") {
    from(layout.buildDirectory.dir("generated/src/main/java"))
    into("src/main/java")
}

tasks.register<Copy>("copyReadme") {
    from(file(layout.buildDirectory.file("generated/README.md")))
    into(file("$rootDir/"))
}

tasks.register("removeWrongDocumentationLinks") {
    doLast {
        fileTree("$rootDir/docs").files
            .filter { it.isFile }
            .forEach {
                val content = it.readText()
                    .replace("[**OffsetDateTime**](OffsetDateTime.md)", "**OffsetDateTime**")
                    .replace("[**URI**](URI.md)", "**URI**")
                it.writeText(content)
            }
    }
}

tasks.named("copyDocs") {
    dependsOn(tasks.openApiGenerate)
    dependsOn("removeDocs")
}
tasks.named("copyClasses") {
    dependsOn(tasks.openApiGenerate)
    dependsOn("removeClasses")
}

tasks.named("removeWrongDocumentationLinks") {
    dependsOn("copyDocs")
    finalizedBy("copyReadme")
}

tasks.named("build") {
    finalizedBy("removeWrongDocumentationLinks")
}

tasks.compileJava {
    dependsOn("copyClasses")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveBaseName = "fingerprint-pro-server-api-sdk"
}