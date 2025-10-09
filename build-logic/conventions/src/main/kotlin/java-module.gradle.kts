@file:Suppress("UnstableApiUsage")

plugins {
    `java-library`

    id("dependency-management")
    id("testing")
    id("code-quality")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

tasks {
    jar {
        // Change the base name of the JAR archive to avoid any naming collisions for submodules with the same name
        archiveBaseName = "${project.parent?.name}-${project.name}"
    }
}
