pluginManagement {
    repositories {
        google()
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

rootProject.name = "code"
include(":app")
include(":core")
include(":app-features")
include(":app-features:currency-converter")
include(":app-features:currency-result")
include(":app-core")
include(":app-core:ui")
include(":app-core:data")
include(":app-core:data:network")
include(":app-core:data:database")
include(":app-core:data:preferences")
include(":app-core:common")
include(":app-core:models")
include(":app-factories")
include(":app-factories:api-factory")
include(":app-factories:fake-factory")
