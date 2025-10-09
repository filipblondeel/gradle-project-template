import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("java-module")
    alias(libs.plugins.springBoot)
    alias(libs.plugins.gradleGitProperties)
}

springBoot {
    /*
        Generates build info to be exposed by the info actuator endpoint.
        The 'time' property is excluded to leverage Gradle's task avoidance for the bootBuildInfo task. See
        https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#integrating-with-actuator.build-info
    */
    buildInfo {
        properties {
            excludes.set(setOf("time"))
        }
    }
}

tasks.named<BootRun>("bootRun") {
    // Sets the Spring Boot profile for running locally using the bootRun Gradle task
    systemProperty("spring.profiles.active", "local")
}

tasks.named<BootBuildImage>("bootBuildImage") {
    // Sets the name of the Docker image that this task will build
    imageName.set("${project.group}/${project.name}")

    environment.set(environment.get() + mapOf(
        // Set the JVM version to the target compatibility version
        "BP_JVM_VERSION" to project.java.targetCompatibility.toString(),

        // Minimal JRE with JLink  - https://paketo.io/docs/howto/java/#install-a-minimal-jre-with-jlink
        "BP_JVM_JLINK_ENABLED" to "true"
    ))
}
