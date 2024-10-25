plugins {
    alias(libs.plugins.hm.android.library)
    alias(libs.plugins.hm.android.hilt)
}

android {
    namespace = "com.example.domain"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}