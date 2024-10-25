import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.configureKotlinAndroid
import com.example.convention.library
import com.example.convention.version
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = version("applicationId").toString()
                    targetSdk = version("targetSdk").toString().toInt()
                    versionCode = version("versionCode").toString().toInt()
                    versionName = version("versionName").toString()
                }

                configureKotlinAndroid(this)
            }
            dependencies {
                "testImplementation"(library("junit.junit"))
                "androidTestImplementation"(library("junit"))
                "androidTestImplementation"(library("androidx.test.espresso.core"))
                "implementation"(library("orhanobut.logger"))
            }

        }
    }
}