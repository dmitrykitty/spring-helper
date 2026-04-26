plugins {
    java
    id("org.springframework.boot") version "4.0.6"
    id("io.spring.dependency-management") version "1.1.7"
}
val springShellVersion by extra("4.0.1")

group = "com.dnikitin"
version = "0.0.1-SNAPSHOT"
description = "spring-boot-demo"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.shell:spring-shell-starter")
    implementation("org.springframework.shell:spring-shell-jline")
    implementation("net.java.dev.jna:jna:5.17.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.shell:spring-shell-dependencies:$springShellVersion")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
