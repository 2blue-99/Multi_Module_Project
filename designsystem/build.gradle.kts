plugins {
    alias(libs.plugins.hm.android.library)
    alias(libs.plugins.hm.android.library.compose)
}

android {
    namespace = "com.example.designsystem"
}

dependencies {
    debugApi(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
}