val projectVersion: String by project

group = "com.fingerprint"
version = projectVersion

plugins {
    application
    java
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(project(":sdk"))
}

sourceSets {
    main {
        java {
            srcDir("src/main/java")
        }
    }
}

tasks.register<JavaExec>("runFunctionalTests") {
    group = "execute"
    description = "Run the Functional Tests"
    mainClass = "com.fingerprint.example.FunctionalTests"
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.named("runFunctionalTests") {
    dependsOn("build")
}