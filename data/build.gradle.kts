import org.gradle.api.tasks.JavaExec

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.10/userguide/building_java_projects.html in the Gradle documentation.
 */

val mainPath: String = "org.cityShop.app.Main"

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}
// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    // Define the main class for the application.
    mainClass = mainPath
}

dependencies {

    implementation("org.json:json:20240303")
}

tasks.jar {

    manifest {

        attributes["Main-Class"] = mainPath

    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })

}

tasks.named<JavaExec>("run") {

    standardInput = System.`in`
/*
    doFirst{
        val activeDB = file("./src/resources/active.json");

        if (activeDB.exists()){

            activeDB.delete();
            println("Deleted file: ${activeDB.absolutePath}")

        } else {
            println("File not found: ${activeDB.absolutePath}")
        }

    }
    */


}

