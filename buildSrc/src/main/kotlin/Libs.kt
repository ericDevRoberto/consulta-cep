object Libs {
    //Kotlin
    const val kotlinCore = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"

    //core
    const val androidCore = "androidx.core:core-ktx:${Versions.coreVersion}"

    //AppCompat
    const val appcompatCore = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"

    //Material
    const val materialCore = "com.google.android.material:material:${Versions.materialVersion}"

    //ConstrainLayout
    const val constrainCore =
        "androidx.constraintlayout:constraintlayout:${Versions.constrainVersion}"

    //Vector Drawable
    const val drawableCore = "androidx.vectordrawable:vectordrawable:${Versions.drawableVersion}"

    //Navigation
    const val navigationCore = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    //Lifecycle
    const val lifecyleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecyleVersion}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecyleVersion}"

    //Retrofit
    const val retrofitCore = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"

    //Moshi
    const val moshiCore = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"

    //Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomCore = "androidx.room:room-ktx:${Versions.roomVersion}"

    //Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    //Koin
    const val koinCore = "org.koin:koin-core:${Versions.koinVersion}"
    const val koinAndroidCore = "org.koin:koin-android:${Versions.koinVersion}"
    const val koinScope = "org.koin:koin-android-scope:${Versions.koinVersion}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koinVersion}"
}