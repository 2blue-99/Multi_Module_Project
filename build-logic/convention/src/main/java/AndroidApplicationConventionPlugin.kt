import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.configureKotlinAndroid
import com.example.convention.libs
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
                    applicationId = libs.findVersion("applicationId").get().toString()
                    targetSdk = libs.findVersion("targetSdk").get().toString().toInt()
                    versionCode = libs.findVersion("versionCode").get().toString().toInt()
                    versionName = libs.findVersion("versionName").get().toString()
                }

                configureKotlinAndroid(this)
            }
            dependencies {
                "testImplementation"(libs.findLibrary("junit.junit").get())
                "androidTestImplementation"(libs.findLibrary("junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx.test.espresso.core").get())
                "implementation"(libs.findLibrary("orhanobut.logger").get())
            }

        }
    }
}