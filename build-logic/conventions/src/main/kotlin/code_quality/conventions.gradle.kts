package code_quality

plugins {
	`java-library`

	id("code_quality.coverage")
	id("code_quality.errorprone")
	id("code_quality.cve-analysis")
}
