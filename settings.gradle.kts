pluginManagement {

    includeBuild("build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Multi_Module_Practice"
include(":app")
include(":domain")
include(":presentation")
include(":designsystem")
include(":data")
