@file:Suppress("UnstableApiUsage")

rootProject.name = "gradle-project-template"

plugins {
    // Gradle pre-commit Git Hooks - https://github.com/DanySK/gradle-pre-commit-git-hooks
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.1.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

includeBuild("build-logic") // preferred over using buildSrc

/**
 * The example modules of this project
 */
include(
    "example-plain-java-module",
    "example-spring-boot-app",
    "example-node-module",
)
