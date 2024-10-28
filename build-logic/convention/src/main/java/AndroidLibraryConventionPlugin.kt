import com.android.build.gradle.LibraryExtension
import com.example.convention.ExtensionType
import com.example.convention.configureBuildTypes
import com.example.convention.configureKotlinAndroid
import com.example.convention.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * 컴포즈가 필요없는 모듈에서 쓰임
 */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.LIBRARY
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