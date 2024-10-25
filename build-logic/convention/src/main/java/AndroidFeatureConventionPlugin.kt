import com.android.build.gradle.LibraryExtension
import com.example.convention.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            pluginManager.apply{
                apply("my.android.library")
                apply("my.android.hilt")
            }

            extensions.configure<LibraryExtension>{
                defaultConfig{
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            dependencies {
                add("implementation", project(":designsystem"))
                add("implementation", project(":domain"))

                add("implementation", library("androidx.hilt.navigation.compose"))
                add("implementation", library("androidx.lifecycle.runtimeCompose"))
                add("implementation", library("androidx.lifecycle.viewModelCompose"))
                add("implementation", library("kotlinx.coroutines.android"))
                add("implementation", library("orhanobut.logger"))
                add("implementation", library("androidx.navigation.compose"))
            }
        }
    }
}