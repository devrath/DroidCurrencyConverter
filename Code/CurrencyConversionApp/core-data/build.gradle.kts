plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.istudio.core"
}

dependencies {
    dataModuleDependencies()
}