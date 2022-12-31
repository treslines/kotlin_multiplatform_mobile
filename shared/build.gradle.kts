import com.codingfeline.buildkonfig.compiler.FieldSpec

plugins {
    kotlin(Plugins.multiplatform)
    id(Plugins.androidLibrary)
    id(SqlDelight.pluginId)
    id(BuildKonfig.pluginId)
    kotlin(Jetbrains.serializationPluginId)
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies{
                implementation(Kotlinx.coroutinesCore)
                implementation(SqlDelight.driverCommon)
                implementation(Jetbrains.serializationKotlinCore)
                implementation(Ktor.core)
                implementation(Ktor.jsonSerialization)
                implementation(Ktor.serialization)
                implementation(Ktor.clientContentNegotiation)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Kotlinx.coroutinesTest)
                implementation(kotlin("test"))

                implementation(Test.kotlinCommon)
                implementation(Test.kotlinAnnotation)
//                implementation(Mockk.core)
//                implementation(Mockk.common)
            }
        }
        val androidMain by getting {
            dependencies {
                api(Androidx.viewModelLifecycle)
                implementation(SqlDelight.driverAndroid)
                implementation(Ktor.clientOkhttp)
                implementation(Compose.uiGraphics)
            }
        }
        val androidTest by getting {
            dependencies{
                implementation(Test.junit)
            }
        }
        val androidAndroidTest by getting {
            dependencies {
                implementation(Test.instrumentedCommonJunit)
                implementation(Test.instrumentedCommonJunitKtx)
                implementation(Test.instrumentedCommonEspresso)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies{
                implementation(SqlDelight.driverIos)
                implementation(Ktor.clientDarwin)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = Namespaces.shared
    compileSdk = Playstore.compileSdk
    defaultConfig {
        minSdk = Playstore.minSdk
        targetSdk = Playstore.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packagingOptions {
        resources {
            excludes += mutableSetOf("META-INF/LICENSE.md", "META-INF/LICENSE-notice.md")
        }
    }
    flavorDimensions += "environment"
    productFlavors {
        create("development") {
            dimension = "environment"
        }
        create("production") {
            dimension = "environment"
        }
        create("integration") {
            dimension = "environment"
        }
    }
}

// 6) Configurar sqldelight no build.gradle (siga sequencia e so insira isso no passo 6)
sqldelight {
    database(SqlDelight.databaseScheme){
        packageName = SqlDelight.databasePackage
    }
}

buildkonfig {
    packageName = Playstore.applicationId
    exposeObjectWithName = "CommonConfig" // Name of the common build config we specify

    val flavorProps = project.properties["FLAVOR_PROPERTIES"]
    val envProps = if(flavorProps != null) flavorProps as Map<*,*> else null

    if(envProps != null && envProps.isNotEmpty()){
        defaultConfigs {
            buildConfigField(FieldSpec.Type.STRING, "LOKALISE_PROJEKT_ID", envProps["LOKALISE_PROJEKT_ID"].toString(), false,true)
            buildConfigField(FieldSpec.Type.STRING, "LOKALISE_TOKEN", envProps["LOKALISE_TOKEN"].toString(), false, true)
            buildConfigField(FieldSpec.Type.STRING, "ADOBE_APP_ID", envProps["ADOBE_APP_ID"].toString(),false, true)
            buildConfigField(FieldSpec.Type.STRING, "FLAVOR", envProps["FLAVOR"].toString(),false, true)
        }
    } else {
        defaultConfigs {}
    }
}