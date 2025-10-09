@file:Suppress("UnstableApiUsage")

import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    `java-library`
    `java-test-fixtures`
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

        register<JvmTestSuite>("integrationTest") {
            useJUnitJupiter()

            dependencies {
                /*
                 * This allows the integration test code to see the public types defined in the main source set's code,
                 * plus any dependencies declared in the `api` configuration – but not those declared in the
                 * `implementation` configuration.
                 *
                 * The logic behind this is that integration tests should only see the same types
                 * that a consuming project would by default. This makes sense since they are "integration tests",
                 * testing the external, not internal, API of the project.
                 */
                implementation(project())
            }

            targets {
                all {
                    testTask.configure {
                        // Configure the default display name generator for all integration tests
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

tasks {

    val integrationTest by named("integrationTest") {
        shouldRunAfter(test)
    }

    check {
        dependsOn(integrationTest)
    }
}
