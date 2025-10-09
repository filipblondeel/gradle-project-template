@file:Suppress("UnstableApiUsage")

import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    `java-library`
    alias(libs.plugins.springDependencyManagement)
}

val springBootBom: String = SpringBootPlugin.BOM_COORDINATES

dependencyManagement {
    imports {
        mavenBom(springBootBom)
    }
}

with(project.the<TestingExtension>()) {
    suites {
        all {
            dependencyManagement {
                imports {
                    mavenBom(springBootBom)
                }
            }
        }
    }
}
