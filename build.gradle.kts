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
        classpath(BuildKonfig.plugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

allprojects {

    repositories {
        google()
        mavenCentral()
        maven { url = uri(Translation.lokaliseUri) }
    }

    // Hack: Determine current build flavor and add it to exported FLAVOR_PROPERTIES
    val tasks = gradle.startParameter.taskRequests.toString()
    if (tasks.contains("assemble")) {
        println("------------assemble------------")
        val pattern = java.util.regex.Pattern.compile("assemble(Development+|Integration+|Production+)")
        val matcher = pattern.matcher(tasks)

        if (matcher.find()) {
            val props = java.util.Properties()
            val flavor = matcher.group(1).toLowerCase()
            val propertiesFile = rootProject.file("androidApp/src/${flavor}/res/keystore.properties")

            props.setProperty("FLAVOR", flavor.toLowerCase())
            props.load(java.io.FileInputStream(propertiesFile))

            // export this flavor based property to all projects
            val FLAVOR_PROPERTIES by extra(props)
            println("Current selected build flavor: ${props["FLAVOR"]} -")
        }
    }
}