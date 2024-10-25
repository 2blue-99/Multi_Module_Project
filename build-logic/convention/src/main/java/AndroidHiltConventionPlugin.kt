import com.example.convention.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("org.jetbrains.kotlin.kapt")
            }
            dependencies {
                "implementation"(library("hilt.android"))
                "kapt"(library("hilt.compiler"))
                "kaptAndroidTest"(library("hilt.compiler"))
                "kaptTest"(library("hilt.compiler"))
            }
        }

    }

}