plugins {
    alias(libs.plugins.my.android.library)
    alias(libs.plugins.my.android.hilt)
}

android {
    namespace = "com.example.domain"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}