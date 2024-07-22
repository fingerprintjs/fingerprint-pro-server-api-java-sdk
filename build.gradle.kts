import org.gradle.internal.declarativedsl.parsing.main
import org.gradle.jvm.tasks.Jar
import org.openapitools.codegen.languages.OpenAPIGenerator
import java.nio.file.Files

val projectVersion: String by project

group = "com.fingerprint"
version = projectVersion

plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.openapi.generator)
	`java-library`
    `maven-publish`
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
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
//
//test {
//    useJUnitPlatform()
//}
//
//javadoc {
//    options.tags = [ "http.response.details:a:Http Response Details" ]
//}
//

sourceSets {
    main {
        java {
            srcDir("src/main/java")
            srcDir("src/examples/java")
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


tasks.withType<Jar>{
    exclude("com/fingerprint/example/**")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.register<Copy>("copyDocs") {
    //dependsOn(openApiGenerate)
    dependencies { openApiGenerate }
    from(layout.buildDirectory.dir("generated/docs"))
    into("docs")
}

tasks.register<Copy>("copyClasses") {
    dependsOn(openApiGenerate)
    from(layout.buildDirectory.dir("generated/src/main/java"))
    into("src/main/java")
}

tasks.register("removeWrongDocumentationLinks") {
    dependsOn("copyDocs")
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

//compileJava.dependsOn tasks.openApiGenerate
//        processResources.dependsOn tasks.openApiGenerate
//

//
//tasks.register('copyDocs', Copy) {
//    into "docs"
//    from layout.buildDirectory.dir("generated/docs")
//}
//copyDocs.dependsOn tasks.openApiGenerate
//
//copyClasses.dependsOn tasks.openApiGenerate
//        compileJava.dependsOn tasks.copyClasses

//removeWrongDocumentationLinks.dependsOn tasks.copyDocs
//
//        tasks.register('runFunctionalTests', JavaExec) {
//            group = "execute"
//            description = "Run the Functional Tests"
//            classpath = sourceSets.main.runtimeClasspath
//            main = 'com.fingerprint.example.FunctionalTests'
//        }
//runFunctionalTests.dependsOn tasks.compileJava
