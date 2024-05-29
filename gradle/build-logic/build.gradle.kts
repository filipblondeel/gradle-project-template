plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

val springBootVersion = "3.3.0"
val gitPropertiesPluginVersion = "2.4.2"

dependencies {
    // see https://docs.spring.io/spring-boot/gradle-plugin/getting-started.html
    implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    // see https://github.com/n0mer/gradle-git-properties
    implementation("com.gorylenko.gradle-git-properties:gradle-git-properties:$gitPropertiesPluginVersion")
}
