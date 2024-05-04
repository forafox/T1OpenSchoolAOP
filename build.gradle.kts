plugins {
    id("java")
    id("io.spring.dependency-management") version "1.1.4"
    id("org.springframework.boot") version "3.2.4"
}

group = "org.forafox"
version = "1.0"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.4")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
    implementation("org.springframework.boot:spring-boot-starter-aop:3.2.4")
    implementation("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.mapstruct:mapstruct:1.5.5")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    implementation("org.mapstruct:mapstruct-processor:1.5.5.Final")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}