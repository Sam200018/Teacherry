import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    // If using Compose Multiplatform, add the compose plugin here
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64(); iosArm64(); iosSimulatorArm64()

    sourceSets {
        androidMain.dependencies {
            // Koin for DI
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.bundles.composeBasics)
            implementation(libs.bundles.viewModel)
            implementation(libs.bundles.koin)
            implementation(project(":shared:features:login-registration:domain"))
            implementation(project(":shared:features:login-registration:presentation"))
        }
    }
}

android {
    namespace = "com.teacherry.features.loginregistration"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
dependencies {
    implementation(project(":composeApp:shared_resources"))
    debugImplementation(compose.uiTooling)
}