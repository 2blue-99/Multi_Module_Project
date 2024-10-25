import com.android.build.gradle.LibraryExtension
import com.example.convention.libs
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
//                add("implementation", project(":core:model"))
                add("implementation", project(":designsystem"))
//                add("implementation", project(":core:data"))
                add("implementation", project(":domain"))


                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
                add("implementation", libs.findLibrary("orhanobut.logger").get())
                add("implementation", libs.findLibrary("androidx.navigation.compose").get())
            }
        }
    }
}