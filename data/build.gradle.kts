plugins {
    alias(libs.plugins.hm.android.library)
    alias(libs.plugins.hm.android.hilt)
}

android {
    namespace = "com.example.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.ext.work)
    implementation(libs.androidx.work.ktx)
    implementation(libs.supabase.compose.auth)
}