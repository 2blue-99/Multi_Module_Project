plugins {
    alias(libs.plugins.my.android.application)
    alias(libs.plugins.my.android.hilt)
    alias(libs.plugins.my.android.application.compose)
    alias(libs.plugins.hilt)
    id("com.google.android.gms.oss-licenses-plugin")
}

android {
    namespace = "com.example.multi_module_practice"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(projects.presentation)
    implementation(projects.designsystem)
    implementation(projects.data)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.hilt.ext.work)
    implementation(libs.androidx.work.ktx)
    implementation (libs.play.services.oss.licenses)
    implementation(libs.androidx.core.splashscreen)
}