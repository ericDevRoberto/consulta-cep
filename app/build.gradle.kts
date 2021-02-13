plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId("com.project.consultcep")
        minSdkVersion(19)
        targetSdkVersion(30)
        versionCode(1)
        versionName("1.0")
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(Libs.kotlinCore)
    implementation(Libs.androidCore)
    implementation(Libs.appcompatCore)
    implementation(Libs.materialCore)
    implementation(Libs.constrainCore)
    implementation(Libs.drawableCore)
    implementation(Libs.navigationCore)
    implementation(Libs.navigationUi)
    implementation(Libs.lifecyleLiveData)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.retrofitCore)
    implementation(Libs.moshiCore)
    implementation(Libs.roomRuntime)
    kapt(Libs.roomCompiler)
    implementation(Libs.roomCore)
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)
    implementation(Libs.koinCore)
    implementation(Libs.koinAndroidCore)
    implementation(Libs.koinScope)
    implementation(Libs.koinViewModel)

    testImplementation(LibTests.junitCore)
    androidTestImplementation(LibTests.junitTest)
    androidTestImplementation(LibTests.espressoCore)
}