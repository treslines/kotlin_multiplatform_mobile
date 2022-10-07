plugins {
    kotlin(Plugins.multiplatform)
    id(Plugins.androidLibrary)
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
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Kotlinx.coroutinesTest)
                implementation(kotlin("test"))

                implementation(Test.kotlinCommon)
                implementation(Test.kotlinAnnotation)
                implementation(Mockk.core)
                implementation(Mockk.common)
            }
        }
        val androidMain by getting {
            dependencies {
                api(Androidx.viewModelLifecycle)
            }
        }
        val androidTest by getting {
            dependencies{
                implementation(Test.junit)
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
    }
}