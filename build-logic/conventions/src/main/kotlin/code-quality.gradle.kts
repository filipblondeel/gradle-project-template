import net.ltgt.gradle.errorprone.errorprone

plugins {
	`java-library`

	// code coverage with JaCoCo
	jacoco
	`jacoco-report-aggregation`

	// Static analysis with "Error Prone"
	alias(libs.plugins.errorprone)
}

dependencies {
	errorprone(libs.errorprone)
}

tasks.withType<JavaCompile>().configureEach {
	options.compilerArgs.addAll(listOf(
		// Enables all recommended compiler warnings but exclude warnings about serialization and annotation processing
		"-Xlint:all,-processing,-serial,-classfile",
		// Treats all compiler warnings as an error :-)
		"-Werror"
	))
	options.errorprone.disableWarningsInGeneratedCode.set(true)
}
