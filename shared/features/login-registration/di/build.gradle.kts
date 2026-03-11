import org.gradle.kotlin.dsl.implementation

plugins {
    // If using Compose Multiplatform, add the compose plugin here
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary) apply true
}

kotlin {
    androidTarget()
    iosX64(); iosArm64(); iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.androidx.lifecycle.viewmodel)

                implementation(project(":shared:features:login-registration:domain"))
                implementation(project(":shared:features:login-registration:data"))
                implementation(project(":shared:features:login-registration:presentation"))

                // Koin for DI
                implementation(project.dependencies.platform(libs.koin.bom))

                // Koin modules (no versions needed)
                implementation(libs.koin.core)
                implementation(libs.koin.compose.viewmodel)

            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            // Add this line to all the targets you want to export this dependency
            export(libs.androidx.lifecycle.viewmodel)
            baseName = "shared"
        }
    }
}

android {
    namespace = "com.teacherry.shared.features.loginregistration.di"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}