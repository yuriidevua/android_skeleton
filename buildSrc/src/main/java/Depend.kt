object Depend {
    val supportAndroidLibs = arrayOf(
        "androidx.annotation:annotation:${Versions.SupportAndroidLibs.supportLibraryAnnotation}",
        "androidx.appcompat:appcompat:${Versions.SupportAndroidLibs.supportLibraryAppCompat}",
        "androidx.cardview:cardview:${Versions.SupportAndroidLibs.cardView}",
        "androidx.recyclerview:recyclerview:${Versions.SupportAndroidLibs.recyclerview}",
        "com.google.android.material:material:${Versions.SupportAndroidLibs.materialDesign}",
        "androidx.constraintlayout:constraintlayout:${Versions.SupportAndroidLibs.constraintLayout}",
        "androidx.window:window:${Versions.SupportAndroidLibs.androidWindow}"
    )

    val androidCameraX = arrayOf(
        "androidx.camera:camera-core:${Versions.CameraX.cameraView}",
        "androidx.camera:camera-view:1.0.0-alpha30",
        "androidx.camera:camera-lifecycle:${Versions.CameraX.cameraView}",
        "androidx.camera:camera-camera2:${Versions.CameraX.cameraView}"
    )
    //Worker
    val workerAndroidLibs = arrayOf(
        "androidx.work:work-runtime:${Versions.SupportAndroidLibs.worker}",
        "androidx.work:work-rxjava2:${Versions.SupportAndroidLibs.worker}",
        "androidx.work:work-multiprocess:${Versions.SupportAndroidLibs.worker}"
    )
    //Multidex
   const val multidexAndroidLib = "androidx.multidex:multidex:${Versions.SupportAndroidLibs.multiDex}"

    // The same here in Kotlin Libraries
    val kotlinDependency = arrayOf(
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KotlinDependency.std}",
        "androidx.core:core-ktx:${Versions.KotlinDependency.std}"
    )

//    const val kotlinKTX = "androidx.core:core-ktx:${Versions.KotlinDependency.std}"

    // The same here in Google Libraries
    val google = arrayOf(
        "com.google.android.gms:play-services-analytics:${Versions.Google.playServices}",
        "com.google.firebase:firebase-core:${Versions.Google.firebase}"
    )
    const val googleLocation = "com.google.android.gms:play-services-location:${Versions.Google.playServices}"
    //Dagger
    val dagger = arrayOf(
        "com.google.dagger:dagger:${Versions.Google.dagger}",
        "com.google.dagger:dagger-android:${Versions.Google.dagger}",
        "com.google.dagger:dagger-android-support:${Versions.Google.dagger}"
    )
    //Dagger AnnotationProcessor
    val daggerAnnotationProcessor = arrayOf(
        "com.google.dagger:dagger-compiler:${Versions.Google.dagger}",
        "com.google.dagger:dagger-android-processor:${Versions.Google.dagger}"
    )
    //Rx
    val rxAndroid = arrayOf(
        "io.reactivex.rxjava3:rxandroid:${Versions.Libraries.rxAndroid}",
        "io.reactivex.rxjava3:rxjava:${Versions.Libraries.rxJava}"
    )

    const val rxPermission = "com.github.tbruyelle:rxpermissions:${Versions.Libraries.rxPermissions}"
    //OkHttp and Retrofit
    val okHttpLibraries = arrayOf(
        "com.squareup.okhttp3:okhttp:${Versions.Libraries.okHttp}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Libraries.okHttp}",
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.Libraries.okHttp}",
        "com.squareup.retrofit2:retrofit:${Versions.Libraries.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Versions.Libraries.retrofit}",
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.Libraries.retrofit}"
    )

    val retrofitConvert =  "com.squareup.retrofit2:converter-gson:${Versions.Libraries.retrofit}"
    //Retrofit Mock
    val retrofitMock = arrayOf("com.squareup.retrofit2:retrofit-mock:${Versions.Libraries.retrofit}")
    //Gson
    const val gson = "com.google.code.gson:gson:${Versions.Libraries.gson}"
    // Google auto value
    const val googleAutoValueCompileOnly = "com.google.auto.value:auto-value:${Versions.Libraries.autoValueGoogle}"

    //Jakewharton auto value AnnotationProcessor
    const val AutoValueAnnotationProcessor = "com.jakewharton.auto.value:auto-value-annotations:${Versions.Libraries.autoValueAnnotations}"

    //Room
    val room = arrayOf(
        "androidx.room:room-runtime:${Versions.Libraries.room}",
        "androidx.room:room-rxjava3:${Versions.Libraries.room}",
        "androidx.room:room-guava:${Versions.Libraries.room}"
    )

    // Room AnnotationProcessor
    const val roomAnnotationProcessor = "androidx.room:room-compiler:${Versions.Libraries.room}"

    //TimberJava
    const val timberJava = "com.jakewharton.timber:timber:${Versions.Libraries.timber}"

    // Glide
    const val libraries = "com.github.bumptech.glide:glide:${Versions.Libraries.glide}"

    // Glide AnnotationProcessor
    const val glideAnnotationProcessor = "com.github.bumptech.glide:compiler:${Versions.Libraries.glide}"

    //Apache
    val apache = arrayOf(
        "org.apache.commons:commons-collections4:${Versions.Libraries.commonsCollections}",
        "commons-io:commons-io:${Versions.Libraries.commons}",
        "commons-codec:commons-codec:${Versions.Libraries.commonsCodec}",
        "org.apache.commons:commons-lang3:3.12.0"
    )
    const val zxing = "com.journeyapps:zxing-android-embedded:${Versions.Libraries.zxing}"

    const val guava = "com.google.guava:guava:31.1-jre"
    // Test unit testImplementation
    const val testUnit = "junit:junit:${Versions.TestLibraries.junit}"
//androidTestImplementation
     val testRunner = arrayOf(
    "androidx.test:runner:${Versions.TestLibraries.runner}",
    "androidx.test.ext:junit:${Versions.TestLibraries.ext}"
)

    //Test Espresso
  const  val testEspresso = "androidx.test.espresso:espresso-core:${Versions.TestLibraries.espresso}"
}