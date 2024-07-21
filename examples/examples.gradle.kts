import org.gradle.internal.declarativedsl.parsing.main
import org.gradle.jvm.tasks.Jar

val projectVersion: String by project

group = "com.fingerprint"
version = projectVersion

plugins {
    alias(libs.plugins.jvm)
    `java-library`
}

repositories {
    mavenLocal()
    mavenCentral()
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

dependencies {
    implementation(project(":sdk"))
}
