plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

kotlin {
    jvmToolchain(24) // Kotlin does not yet support 25 JDK target - using Java 24 for compiling the Gradle .kts build scripts
}
