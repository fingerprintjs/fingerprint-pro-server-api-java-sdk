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

fun loadEnv(): Map<String, String> {
    val envFile = rootProject.file(".env")
    val envMap = mutableMapOf<String, String>()

    if (envFile.exists()) {
        envFile.forEachLine { line ->
            val trimmedLine = line.trim()
            if (trimmedLine.isNotEmpty() && !trimmedLine.startsWith("#") && trimmedLine.contains("=")) {
                val (key, value) = trimmedLine.split("=", limit = 2)
                envMap[key.trim()] = value.trim()
            }
        }
    }
    return envMap
}

tasks.register<JavaExec>("runFunctionalTests") {
    group = "execute"
    description = "Run the Functional Tests"
    mainClass = "com.fingerprint.example.FunctionalTests"
    classpath = sourceSets["main"].runtimeClasspath
    environment(loadEnv())
}

tasks.named("runFunctionalTests") {
    dependsOn("build")
}
