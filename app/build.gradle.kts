import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
android {/*
    signingConfigs {
    appsignin {
        storePassword "happiroo@1234"
        keyPassword "happiroo@1234"
        keyAlias "happiroo"
        storeFile file("/home/bigohtech/vikesh_experiments/Happiroo kotlin/app/happirokey.jks")
    }
    }*/
    compileSdkVersion(Dependency.Android.compileSdkVersion)
    buildToolsVersion(Dependency.Android.buildToolsVersion)

    defaultConfig {
        applicationId = Dependency.Android.applicationId
        minSdkVersion(Dependency.Android.minSdkVersion)
        targetSdkVersion(Dependency.Android.targetSdkVersion)
        versionCode = Dependency.Android.versionCode
        versionName = Dependency.Android.versionName

        testInstrumentationRunner = Dependency.Android.testInstrumentationRunner
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
    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    lintOptions {
        isCheckReleaseBuilds = false
//        abortOnError false
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependency.Dependance.kotlinStdLib)

    implementation("androidx.appcompat:appcompat:1.1.0")

    implementation("com.google.android.gms:play-services-location:17.0.0")

    implementation("com.squareup.retrofit2:retrofit:2.6.2")
    implementation("com.squareup.retrofit2:converter-gson:2.6.2")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("com.github.bumptech.glide:glide:4.9.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.9.0")

    implementation("com.jakewharton:butterknife:10.0.0")
    annotationProcessor("com.jakewharton:butterknife-compiler:10.0.0")
    testImplementation("junit:junit:4.12")

    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    implementation("com.google.android.exoplayer:exoplayer-core:2.12.0")
    implementation("com.google.android.exoplayer:exoplayer-dash:2.12.0")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.12.0")
    implementation(platform("com.google.firebase:firebase-bom:26.2.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.android.gms:play-services-auth:19.0.0")

    implementation(Dependency.Dependance.razerPay)
    implementation(Dependency.Dependance.circleimageview)
    implementation(Dependency.Dependance.PhotoView)
    implementation(Dependency.Dependance.circleindicator)
    implementation(Dependency.Dependance.OtpView)
    implementation(Dependency.Dependance.material)
    implementation(Dependency.Dependance.constraintlayout)
//
    implementation(Dependency.Dependance.lifecycleliveData)
    implementation(Dependency.Dependance.lifecycleViewModel)
    implementation(Dependency.Dependance.lifecycleRuntime)

    //coroutines
    implementation(Dependency.Dependance.coroutinesAndroid)
    implementation(Dependency.Dependance.coroutinesCore)

    //navigation
    implementation(Dependency.Dependance.navigationFragment)
    implementation(Dependency.Dependance.navigationUi)

    val dagger_version = "2.27"
    val hilt_version = "2.37"

    kaptAndroidTest ("com.google.dagger:dagger-compiler:$dagger_version")

    // Hilt dependencies
    implementation ("com.google.dagger:hilt-android:$hilt_version")
    kapt( "com.google.dagger:hilt-android-compiler:$hilt_version")

    // Hilt testing
    androidTestImplementation ("com.google.dagger:hilt-android-testing:$hilt_version")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:$hilt_version")


/*    // Dagger Core
    implementation("com.google.dagger:dagger:2.37")
    kapt("com.google.dagger:dagger-compiler:2.37")

    // Dagger Android
    api("com.google.dagger:dagger-android:2.35.1")
    api("com.google.dagger:dagger-android-support:2.23.2")
    kapt("com.google.dagger:dagger-android-processor:2.23.2")

    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.37")
    kapt("com.google.dagger:hilt-android-compiler:2.37")
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.0.0")*/
 }
