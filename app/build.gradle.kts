import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    lint {
        abortOnError = false
    }
    buildFeatures.dataBinding = true
    namespace = Versions.appliccationId
    compileSdk = Versions.compileSdk
//    signingConfigs {
//        create("release") {
//            storeFile = file("..\\key.jks")
//            storePassword = "PASSWORD"
//            keyAlias = "key"
//            keyPassword = "PASSWORD"
//        }
//        getByName("debug"){
//            storeFile = file("..\\key.jks")
//            storePassword = "PASSWORD"
//            keyAlias = "key"
//            keyPassword = "PASSWORD"
//        }
    defaultConfig {
        applicationId = Versions.appliccationId
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        val appName: String = Versions.appName
        val versionName : String = Versions.versionName
        buildConfigField ("String", "VERSION_NAME","\"${versionName}\"")
        buildConfigField ("String", "APP_NAME","\"${appName}\"")
        setProperty("archivesBaseName", appName + "_" + versionName)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            manifestPlaceholders["versionCode"] = Versions.versionCode
            manifestPlaceholders["appName"] = Versions.appName
                .plus("_")
                .plus(Versions.versionName)
                .plus("_debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
           // signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            manifestPlaceholders["versionCode"] = Versions.versionCode
            manifestPlaceholders["appName"] =  Versions.appName
                .plus("_")
                .plus(Versions.versionName)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
          //  signingConfig = signingConfigs.getByName("release")
        }
    }
    java.toolchain {
        languageVersion.set(JavaLanguageVersion.of(Versions.varsionJava))
    }
    kotlinExtension.jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(Versions.varsionJava))
    }
    configurations.all {
        resolutionStrategy {
            force("androidx.core:core-ktx:1.8.0")
        }
    }
    packagingOptions.resources.excludes += setOf("META-INF/*")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Depend.multidexAndroidLib)
    Depend.kotlinDependency.forEach { implementation(it) }
    // Dagger
    Depend.dagger.forEach { implementation(it) }
    Depend.daggerAnnotationProcessor.forEach { kapt(it) }
    //Retrofit and okHttp
    Depend.okHttpLibraries.forEach { implementation(it) }
    //Gson
    implementation(Depend.gson)
    kapt(Depend.AutoValueAnnotationProcessor)
    compileOnly(Depend.googleAutoValueCompileOnly)
    //RX
    Depend.rxAndroid.forEach { implementation(it) }
    implementation(Depend.rxPermission)
    //Log
    implementation(Depend.timberJava)

//    //Module
    implementation(project(path = ":comm"))
    implementation(project(path = ":portData"))
    implementation(project(path = ":data"))
    implementation(project(path = ":domain"))
    implementation(project(path = ":presentation"))
    implementation(project(path = ":portDomain"))
    implementation(project(path = ":domain"))
    implementation(project(path = ":featureLocalStorage"))
    testImplementation(Depend.testUnit)
    Depend.testRunner.forEach { androidTestImplementation(it) }
}
kapt {
    mapDiagnosticLocations = true // include the Kotlin files into error reports
}