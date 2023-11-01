pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.6.0")
}
rootProject.name = "Android KTS Skeleton Base"
include(":app")


include(":data")
include(":portData")
include(":presentation")


include(":domain")
include(":portDomain")
include(":featureLocalStorage")
include(":comm")
