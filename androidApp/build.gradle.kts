plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
}

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
    flavorDimensions += "tier"
    productFlavors {
        create("development") {
            dimension = "tier"
        }
        create("production") {
            dimension = "tier"
        }
        create("integration") {
            dimension = "tier"
        }
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
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

    // TESTING
    testImplementation(Test.junit)
    androidTestImplementation(TestUi.extJunit)
    androidTestImplementation(Test.instrumentedTestCompose)

    // DEBUGGING
    debugImplementation(Compose.tooling)
}