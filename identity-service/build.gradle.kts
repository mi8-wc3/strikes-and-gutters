plugins {
    id("java")
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
}
dependencies {
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb-reactive
implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive:3.1.3")

    // Inherit dependencies from the root project
//    implementation(project(":"))
}
