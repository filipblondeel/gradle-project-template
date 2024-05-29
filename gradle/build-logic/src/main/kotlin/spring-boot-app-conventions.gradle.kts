import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("java-module-conventions") // see gradle/build-logic/src/main/kotlin/sjava-module-conventions.gradle.kts
    id("org.springframework.boot")
    id("com.gorylenko.gradle-git-properties") // Generates Git information to include in Spring Boot app
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

dependencies {
    developmentOnly(platform(SpringBootPlugin.BOM_COORDINATES))
}

tasks.named<BootRun>("bootRun") {
    // Sets the Spring Boot profile for running locally using the bootRun Gradle task
    systemProperty("spring.profiles.active", "local")
}

tasks.named<BootBuildImage>("bootBuildImage") {
    // Sets the name of the Docker image that this task will build
    imageName.set("${project.group}/${project.name}")

    /*
       This configures the Java buildpack to use an Adoptium JRE of the specified version. The buildpack will download
       the JDK and JRE assets that are compatible with the specified Java version of the JVM specification (see https://github.com/paketo-buildpacks/adoptium/releases for released versions)
       References:
       - https://github.com/paketo-buildpacks/adoptium#gcriopaketo-buildpacksadoptium for more info about the Adoptium buildpack
       - https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#build-image for more info about the Spring Boot Gradle task
    */
    buildpacks.set(listOf("gcr.io/paketo-buildpacks/adoptium", "paketo-buildpacks/java"))
    environment.set(environment.get() + mapOf("BP_JVM_VERSION" to "21"))
}
