pluginManagement {
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
        maven {
            url = uri("https://maven.pkg.github.com/kaseken/KMPLibrarySample")
            credentials {
                username = System.getenv("GITHUB_USERNAME") ?: throw Exception("GITHUB_USERNAME is not set")
                password = System.getenv("GITHUB_TOKEN") ?: throw Exception("GITHUB_TOKEN is not set")
            }
        }
    }
}

rootProject.name = "KMPSampleAndroidApp"
include(":app")
