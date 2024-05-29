@file:Suppress("UnstableApiUsage")

import org.springframework.boot.gradle.plugin.SpringBootPlugin


plugins {
    `java-library`
    `java-test-fixtures`
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
        vendor = JvmVendorSpec.ADOPTIUM
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()

            targets {
                all {
                    testTask.configure(setDefaultJunitProperties())
                }
            }
        }
    }
}

dependencies {
    api(platform(SpringBootPlugin.BOM_COORDINATES))
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    annotationProcessor(platform(SpringBootPlugin.BOM_COORDINATES))
    testImplementation(platform(SpringBootPlugin.BOM_COORDINATES))
    testFixturesApi(platform(SpringBootPlugin.BOM_COORDINATES))
    testFixturesImplementation(platform(SpringBootPlugin.BOM_COORDINATES))
}

fun setDefaultJunitProperties(): (Test).() -> Unit = {
    // Configure the default display name generator for all JUnit tests
    systemProperty(
        "junit.jupiter.displayname.generator.default", "org.junit.jupiter.api.DisplayNameGenerator\$ReplaceUnderscores"
    )
}
