plugins {
    `android-library`
    `kotlin-android`
}

apply<plugins.TestingUtilitiesGradlePlugin>()

android {
    namespace = ProjectConfig.apiFactory
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies {
    coreModelsModule()
    database()
    retrofit()

    // <-- Modules where this mock dependencies are shared-->
    appDatabaseModlue()
}