plugins {
    id("java-module-conventions") // see gradle/build-logic/src/main/kotlin/java-module-conventions.gradle.kts
}

dependencies {
    testImplementation(libs.assertj.core)
}
