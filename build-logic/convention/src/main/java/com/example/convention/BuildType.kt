package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    extensionType: ExtensionType
) {
    commonExtension.run {
        buildFeatures.buildConfig = true

        val debugKey = gradleLocalProperties(rootDir, providers).getProperty("DEBUG_API_KEY")
        val releaseKey = gradleLocalProperties(rootDir, providers).getProperty("RELEASE_API_KEY")

        when(extensionType){
            ExtensionType.APPLICATION -> {
                extensions.configure<ApplicationExtension> {
                    buildTypes {
                        debug {
                            configureDebugBuildType(
                                apiKey = debugKey
                            )
                        }
                        release {
                            configureReleaseBuildType(
                                commonExtension = commonExtension,
                                apiKey = releaseKey
                            )
                        }
                    }
                }
            }
            ExtensionType.LIBRARY -> {
                extensions.configure<LibraryExtension> {
                    buildTypes {
                        debug {
                            configureDebugBuildType(
                                apiKey = debugKey
                            )
                        }
                        release {
                            configureReleaseBuildType(
                                commonExtension = commonExtension,
                                apiKey = releaseKey
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun BuildType.configureDebugBuildType(apiKey: String) {
    isShrinkResources = false // 리소스 축소
    isMinifyEnabled = false // 코드 축소
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
}

private fun BuildType.configureReleaseBuildType(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    apiKey: String
) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    isShrinkResources = true // 리소스 축소
    isMinifyEnabled = true // 코드 축소
    proguardFiles(
        commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}
