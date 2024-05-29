plugins {
    id("spring-boot-app-conventions") // see gradle/build-logic/src/main/kotlin/spring-boot-app-conventions.gradle.kts
}

dependencies {
    implementation(project(":example-plain-java-module"))

    // Spring Boot web application with Thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")

    // Spring Boot Developer Tools - https://docs.spring.io/spring-boot/reference/using/devtools.html
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Generates metadata files for code completion of custom configuration properties
    // See https://docs.spring.io/spring-boot/specification/configuration-metadata/annotation-processor.html
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
