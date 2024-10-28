package com.example.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*,*,*,*,*,*>
) {
    commonExtension.apply {
        buildFeatures.compose = true
        composeOptions.kotlinCompilerExtensionVersion = version("androidxComposeCompiler").toString()
    }

    dependencies {
        val bom = library("androidx-compose-bom")
        add("implementation", platform(bom))
        add("androidTestImplementation", platform(bom))
        add("implementation", library("androidx.compose.ui.tooling.preview"))

        add("debugImplementation", library("androidx.compose.ui.testManifest"))
        add("implementation", library("androidx.compose.material3"))
        add("implementation", library("androidx.compose.ui.util"))
    }
}