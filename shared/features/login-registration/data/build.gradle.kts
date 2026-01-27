import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    // If you use SQLDelight or Serialization, add plugins here
//    kotlin("plugin.serialization") version "1.9.20"
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64(); iosArm64(); iosSimulatorArm64()



    sourceSets {
        val commonMain by getting {
            dependencies {
                // DEP: DATA CONSULTE DOMAIN
                implementation(project(":shared:features:login-registration:domain"))

                // Koin for DI
                implementation(project.dependencies.platform(libs.koin.bom))

                // Coroutines
                implementation(libs.kotlinx.coroutines.core)
            }
        }
    }
}


android {
    namespace = "com.teacherry.shared.features.loginregistration.data"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}