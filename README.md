# Gradle Project Template

## 📋 Requirements

The following software has to be installed on your computer to be able to build and run the software:

* Git
* JDK >= 25. If you use [SDKMAN!](https://sdkman.io/) to manage your Java installations, you can install the required 
JDK by running the following command:
   ```shell
   sdk env install
   ```

## 📦 Building

Gradle is the build tool of this project. The Gradle `build` task can be used to test and build the source code:

```shell
./gradlew build
```

## ✅ Testing

This project uses a combination of fast running 'unit' tests and 'slower' integration tests to verify the correctness
of the source code.

All tests can be run with the Gradle `check` task as follows:

```shell
./gradlew check
```

### Unit tests

Per module, the 'unit' tests can be found in the `src/test/java` folder. They can be run with Gradle like this:

```shell
./gradlew test
```

### Integration tests

Per module, the integration tests can be found in the `src/integrationTest/java` folder. Run them with Gradle like this:

```shell
./gradlew integrationTest
```

## 🚀 Running the Spring Boot application

Running the Spring Boot application locally can be done with Gradle like this:

```shell
./gradlew bootRun
```

The Gradle `bootRun` task has been configured to activate the `local` profile by default.

## 🧑‍💻 IntelliJ IDEA setup

### Run/debug configurations

IntelliJ run configurations have been provided in the [intellij](./intellij) folder for:
- [doing a full build](./intellij/Do%20full%20build.run.xml)
- [running all tests](./intellij/Run%20all%20tests.run.xml)
- [running only the unit tests](./intellij/Run%20unit%20tests.run.xml)
- [running the Spring Boot application](./intellij/Run%20Spring%20Boot%20app.run.xml)

## ❓ How to

### Upgrade dependencies and plugins

All dependency and plugin versions are managed with a Gradle version catalog. From the Gradle manual:

> A version catalog is a list of dependencies, represented as dependency coordinates, that a user can pick from
> when declaring dependencies in a build script.

The actual versions used in this project can be found in the [gradle/libs.versions.toml](gradle/libs.versions.toml) file.
Changing any version in this TOML file is all what's needed to upgrade the dependency or plugin.

### Upgrade Java

To upgrade Java, you need to make the following changes:

1. Change the version of the Java toolchain used by Gradle in the [Java module convention plugin](build-logic/conventions/src/main/kotlin/java-module.gradle.kts)
2. Specify the new version in the [SDKMAN!](https://sdkman.io/) configuration file [.sdkmanrc](.sdkmanrc) and install it
   by running:
   ```shell
   sdk env install
   ```
3. Use the new JDK as your project SDK in your IDE. Follow [these](https://www.jetbrains.com/help/idea/2022.3/sdk.html#set-up-jdk) instructions for setting up the
   project JDK in IntelliJ.

### Upgrade Gradle

The [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) is used to build this software.
Upgrading Gradle can be done by updating your wrapper properties:

```shell
./gradlew wrapper --gradle-version=<new_version>
```
