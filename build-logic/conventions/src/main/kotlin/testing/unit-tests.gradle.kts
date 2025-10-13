@file:Suppress("UnstableApiUsage")

package testing

import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    java
    `jvm-test-suite`
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()

            targets {
                all {
                    testTask.configure {
                        // Configure the default display name generator for all JUnit tests
                        systemProperty(
                            "junit.jupiter.displayname.generator.default",
                            "org.junit.jupiter.api.DisplayNameGenerator\$ReplaceUnderscores"
                        )

                        jvmArgs("-XX:+EnableDynamicAgentLoading", "-Xshare:off")

                        testLogging {
                            exceptionFormat = TestExceptionFormat.FULL
                        }
                    }
                }
            }
        }
    }
}
