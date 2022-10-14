plugins {
    //trick: for the same plugin versions in all sub-modules
    id(Plugins.androidApplication).version(Versions.pluginAndroidApp).apply(false)
    id(Plugins.androidLibrary).version(Versions.pluginAndroidLib).apply(false)
    kotlin(Plugins.android).version(Versions.kotlin).apply(false)
    kotlin(Plugins.multiplatform).version(Versions.kotlin).apply(false)
}

buildscript {
    dependencies {
        classpath(Gradle.pluginSqlDelight)
        classpath(Jetbrains.serializationKotlin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
