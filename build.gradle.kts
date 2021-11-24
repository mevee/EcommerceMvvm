// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        jcenter()
        maven { url= uri("https://jitpack.io") }
    }
    dependencies {
        classpath(Dependency.Project.androidGradle)
        classpath(Dependency.Project.kotlinGradlePlugin)
        classpath(Dependency.Project.googleServices)
        classpath(Dependency.Project.hiltGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url= uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
