plugins {
	alias(libs.plugins.node)
}

// See https://github.com/node-gradle/gradle-node-plugin/blob/main/docs/usage.md#configuring-the-plugin
node {
	download = true
	version = "20.11.0" // also see .nvmrc
	npmInstallCommand = "ci"
}
