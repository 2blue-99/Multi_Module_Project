import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.ExtensionType
import com.example.convention.configureBuildTypes
import com.example.convention.configureKotlinAndroid
import com.example.convention.library
import com.example.convention.version
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * 앱 모듈에서 사용하는 베이스 플로그인
 */
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
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

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.APPLICATION
                )
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