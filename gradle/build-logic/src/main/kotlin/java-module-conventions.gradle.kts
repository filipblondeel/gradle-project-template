@file:Suppress("UnstableApiUsage")

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

fun setDefaultJunitProperties(): (Test).() -> Unit = {
    // Configure the default display name generator for all JUnit tests
    systemProperty(
        "junit.jupiter.displayname.generator.default", "org.junit.jupiter.api.DisplayNameGenerator\$ReplaceUnderscores"
    )
}
