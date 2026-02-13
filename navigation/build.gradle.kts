plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

apply(from = rootProject.file("common.gradle"))

android {
    namespace = "com.wcsm.navigation"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // App Módules
    implementation(project(":core"))
    implementation(project(":feature:champions"))
    implementation(project(":feature:items"))


}