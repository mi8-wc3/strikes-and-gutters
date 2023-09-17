plugins {

    id("java")
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
}
tasks.jar {
    manifest.attributes["Main-Class"] = "com.example.MyMainClass"
    manifest.attributes["Class-Path"] = configurations
        .runtimeClasspath
        .get()
        .joinToString(separator = " ") { file ->
            "libs/${file.name}"
        }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}


dependencies {
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb-reactive
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive:3.1.3")

    // Inherit dependencies from the root project
    implementation(project(":"))


}
