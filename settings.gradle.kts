@file:Suppress("UnstableApiUsage")

rootProject.name = "gradle-project-template"

pluginManagement {
    includeBuild("gradle/build-logic") // preferred over using buildSrc
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(
    "example-plain-java-module",
    "example-spring-boot-module"
)
