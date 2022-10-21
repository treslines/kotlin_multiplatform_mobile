
// 1) Definir dependências / Android dolphin ja cria com compose
// 2) adicionar dependencias
// 3) enxergar o beneficio da centralização das dependências


/** PLAYSTORE VERSIONS */
object Playstore {
    const val applicationId = "br.com.progdeelite.kmmprogdeelite.android" // can't change once defined
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 33
    const val versionCode = 1       // must be increased by every playstore upload
    const val versionName = "1.0.0" // you should increase too. Suggested approach (https://semver.org/)
}

object Namespaces {
    const val android = "br.com.progdeelite.kmmprogdeelite.android"
    const val shared = "br.com.progdeelite.kmmprogdeelite"
}

object Plugins {
    const val android = "android"
    const val androidLibrary = "com.android.library"
    const val androidApplication = "com.android.application"
    const val kotlin = "kotlin"
    const val multiplatform = "multiplatform"
}

/** DEPENDENCY VERSIONS */
object Versions {
    const val compose = "1.1.1"
    const val composeActivity = "1.4.0"
    const val composeCompiler = "1.3.1"
    const val composeThemeAdapter = "1.1.5"
    const val androidxCore = "1.9.0"
    const val lifecycleRuntime = "2.5.1"
    const val junit = "4.13.2"
    const val extJunit = "1.1.3"
    const val instrumentedTestCompose = "1.2.1"
    const val testManifest = "1.1.0-beta01"
    const val espressoCore = "3.4.0"
    const val uiUnitTest = "1.1.0-beta01"
    const val kotlin = "1.7.10"
    const val pluginAndroidLib = "7.3.0"
    const val pluginAndroidApp = "7.3.0"
    const val viewModel = "2.5.1"
    const val kotlinx = "1.6.4"
    const val mockkCommon = "1.12.5"
    const val mockkCore = "1.13.2"
    const val sqlDelight = "1.5.3"
    const val kotlinSerializationCore = "1.3.2"
    const val buildTools = "7.3.0"
    const val shimmer = "1.0.3"
}

object Jetbrains {
    const val serializationPluginId = "plugin.serialization"
    const val serializationKotlin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    const val serializationKotlinCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinSerializationCore}"
}

object Gradle {
    const val pluginSqlDelight = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
    const val pluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val buildTools = "com.android.tools.build:gradle${Versions.buildTools}"

}

object SqlDelight {
    const val pluginId = "com.squareup.sqldelight"
    const val driverCommon = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
    const val driverAndroid = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    const val driverIos = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
    const val databasePackage = "br.com.progdeelite.kmmprogdeelite.database"
    const val databaseScheme = "CommonDatabase"
}

/**
 * APP DEPENDENCIES
 * How to add to build.gradle(:app)?
 * Ex: Inside dependencies{...} add: implementation Androidx.core
 */
object Androidx {
    const val core = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
    const val viewModelLifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
}

object Kotlinx {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinx}"
}

object Compose {
    const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val themeAdapter = "com.google.android.material:compose-theme-adapter:${Versions.composeThemeAdapter}"
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val shimmer = "com.valentinilk.shimmer:compose-shimmer:${Versions.shimmer}"
}

/**
 * UNIT TEST
 * How to add to build.gradle(:app)?
 * Ex: Inside dependencies{...} add: testImplementation Test.junit
 */
object Test {
    const val junit = "junit:junit:${Versions.junit}"
    const val kotlinAnnotation = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
    const val kotlinCommon = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
    const val instrumentedTestCompose = "androidx.compose.ui:ui-test-junit4:${Versions.instrumentedTestCompose}"
}

object Mockk {
    const val core = "io.mockk:mockk:${Versions.mockkCore}"
    const val common = "io.mockk:mockk-common:${Versions.mockkCommon}"
}

/**
 * ANDROID UI TESTS
 * How to add to build.gradle(:app)?
 * Ex: Inside dependencies{...} add: androidTestImplementation TestUi.espressoCore
 */
object TestUi {
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val uiUnitTest = "androidx.compose.ui:ui-test-junit4:${Versions.uiUnitTest}"
}

/**
 * DEBUG TESTS
 * How to add to build.gradle(:app)?
 * Ex: Inside dependencies{...} add: debugImplementation Debug.testManifest
 */
object Debug {
    const val testManifest = "androidx.compose.ui:ui-test-manifest:${Versions.testManifest}"
}