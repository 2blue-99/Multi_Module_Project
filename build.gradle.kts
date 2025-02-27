// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath("com.google.android.gms:oss-licenses-plugin:0.10.6")
    }
}

plugins {
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.secrets) apply false
    alias(libs.plugins.ksp) apply false
}