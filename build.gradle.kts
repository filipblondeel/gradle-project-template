plugins {
    base
    `jacoco-report-aggregation`
    alias(libs.plugins.sonar)
}

group = "gradle-project-template"

sonar {
    properties {
        property("sonar.organization", "fiftythree-it")
        property("sonar.projectKey", "gradle-project-template")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.sourceEncoding", "UTF-8")
    }
}
