val projectVersion: String by project

group = "com.fingerprint"
version = projectVersion

plugins {
    alias(libs.plugins.jvm)
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
        register("mavenJava", MavenPublication::class) {
            artifactId = "fingerprint-pro-server-api-sdk"
        }
        register("localMavenJava", MavenPublication::class) {
            groupId = "com.fingerprint"
            artifactId = "fingerprint-pro-server-api-sdk"
            version = projectVersion
        }
    }
}

dependencies {
    implementation(libs.swagger.annotations)
    implementation(libs.jsr305)
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
    outputDir.set("$buildDir/generated")
    groupId.set("com.fingerprint")
    id.set("fingerprint-pro-server-api-sdk")
    version.set("5.1.1")
    apiPackage.set("com.fingerprint.api")
    modelPackage.set("com.fingerprint.model")
    invokerPackage.set("com.fingerprint.sdk")
    library.set("jersey2")
    templateDir.set("template")

    gitHost.set("github.com")
    gitRepoId.set("fingerprint-pro-server-api-java-sdk")
    gitUserId.set("fingerprintjs")
    configOptions.put("hideGenerationTimestamp", "true")
}

tasks.register<Copy>("copyDocs") {
    from(layout.buildDirectory.dir("generated/docs"))
    into("docs")
}

tasks.register<Copy>("copyClasses") {
    from(layout.buildDirectory.dir("generated/src/main/java"))
    into("src/main/java")
}

tasks.register("removeWrongDocumentationLinks") {
    doLast {
        fileTree("./docs").files
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
}
tasks.named("copyClasses") {
    dependsOn(tasks.openApiGenerate)
}
tasks.named("removeWrongDocumentationLinks") {
    dependsOn("copyDocs")
}
tasks.named("build") {
    finalizedBy("removeWrongDocumentationLinks")
}

tasks.compileJava {
    dependsOn(tasks.withType<Copy>())
}
