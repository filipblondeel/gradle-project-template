plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

kotlin {
    jvmToolchain(21) // Currently only Java 21 is supported by the embedded Kotlin compiler for the Gradle .kts build scripts
}
