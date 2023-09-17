import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    idea
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
}
application {
    mainClass.set("org.mi8qa.strikes.gutters.service.identity.IdentityServiceApplication")
}


group = "app.mi8qa"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

extra["snippetsDir"] = file("build/generated-snippets")
subprojects {


    group = "app.mi8qa"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "java")
    apply(plugin = "idea")
    apply(plugin = "kotlin")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.3")

        // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-r2dbc
        implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.1.3")
// https://mvnrepository.com/artifact/org.mockito/mockito-core
        implementation("org.mockito:mockito-core:5.5.0")

//        implementation("org.springframework.boot:spring-boot-starter-actuator:3.1.3")
//        implementation("org.springframework.boot:spring-boot-starter-batch:3.1.3")
        implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.1.3")
//        implementation("org.springframework.boot:spring-boot-starter-mail:3.1.3")
//        implementation("org.springframework.boot:spring-boot-starter-quartz:3.1.3")
        implementation("org.springframework.boot:spring-boot-starter-security:3.1.3")
        implementation("org.springframework.boot:spring-boot-starter-validation:3.1.3")
        implementation("org.springframework.boot:spring-boot-starter-webflux:3.1.3")
        implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.2.0")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")

        implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.2.2")
        runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.9.10")
        runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.3")
        implementation("org.springframework:spring-core:6.0.11")
        implementation("org.postgresql:r2dbc-postgresql:1.0.2.RELEASE")
        implementation("org.springframework.boot:spring-boot-configuration-processor:3.1.3")
        testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.3")
        testImplementation("org.springframework.boot:spring-boot-testcontainers:3.1.3")
        testImplementation("io.projectreactor:reactor-test:3.5.9")
        implementation("org.springframework.batch:spring-batch-core:5.0.3")
        testImplementation("org.springframework.restdocs:spring-restdocs-webtestclient:3.0.0")
        testImplementation("org.springframework.security:spring-security-test:6.1.3")
        testImplementation("org.testcontainers:r2dbc:1.19.0")
        testImplementation("org.testcontainers:testcontainers:1.19.0")
        testImplementation("org.springframework.boot:spring-boot-docker-compose:3.1.1")
        // https://mvnrepository.com/artifact/io.r2dbc/r2dbc-h2
        implementation("io.r2dbc:r2dbc-h2:1.0.0.RELEASE")

    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks.test {
//	outputs.dir(snippetsDir)
//}
//
//tasks.asciidoctor {
//	inputs.dir(snippetsDir)
//	dependsOn(test)
//}
