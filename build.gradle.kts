// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
   // ext.kotlin_version = "1.4.21"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.1.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.3")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }


}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}

//
//task clean(type: Delete) {
//    delete rootProject.buildDir
//}