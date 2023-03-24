
plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
}

val flavorProps = project.properties["FLAVOR_PROPERTIES"]
val envProps = if(flavorProps != null) flavorProps as Map<*,*> else null

android {
    namespace = Namespaces.android
    compileSdk = Playstore.compileSdk
    defaultConfig {
        applicationId = Playstore.applicationId
        minSdk = Playstore.minSdk
        targetSdk = Playstore.targetSdk
        versionCode = Playstore.versionCode
        versionName = Playstore.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJunitRunner"
    }

    if(envProps != null && envProps.isNotEmpty()){
        println("--------props-----------")
        envProps.forEach {
            println("key:${it.key} - value:${it.value}")
        }
        println("--------props-----------")
        val keystoreJksSecret = System.getenv("KEYSTORE_JKS_PASSWORD")
        signingConfigs {
            // Creates a signing configuration called "release".
            create("release") {
                storeFile=file(envProps["storeFile"] as Any)      // path to your keystore file.
                storePassword=keystoreJksSecret                   // password for your keystore.
                keyAlias=envProps["keyAlias"] as String           // identifying name for your key.
                keyPassword=keystoreJksSecret                     // password for your key.
            }
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    // Environments (Ambientes de desenvolvimento)
    flavorDimensions += "environment"
    productFlavors {
        create("development") {
            applicationIdSuffix=".dev"
            signingConfig = signingConfigs.getByName("debug")
            dimension = "environment"
        }
        create("integration") {
            applicationIdSuffix=".int"
            signingConfig = signingConfigs.getByName("debug")
            dimension = "environment"
        }
        create("production") {
            dimension = "environment"
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            isMinifyEnabled = false
            isDebuggable = true
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            if(signingConfig != null) {
                signingConfig = signingConfigs.getByName("release")
            }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":shared"))

    // CORE
    implementation(Androidx.core)
    implementation(Androidx.lifecycleRuntime)

    // CORE LIBS
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.toolingPreview)
    implementation(Compose.foundation)
    implementation(Compose.activity)
    implementation(Compose.layout)
    implementation(Compose.themeAdapter)
    implementation(Compose.runtime)
    implementation(Compose.materialIconsExtended)
    implementation(Compose.shimmer)
    implementation(Compose.lottie)
    implementation(Compose.viewModelCompose)

    // LOKALISE
    implementation(Translation.lokaliseSdk)

    // ADOBE
    implementation(Adobe.core)
    implementation(Adobe.analytics)
    implementation(Adobe.sdkCore)

    // TESTING
    testImplementation(Test.junit)
    androidTestImplementation(TestUi.extJunit)
    androidTestImplementation(Test.instrumentedTestCompose)

    // DEBUGGING
    debugImplementation(Compose.tooling)
}