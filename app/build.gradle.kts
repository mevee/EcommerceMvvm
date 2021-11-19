plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
//    id("kotlin-kapt")
//    id("dagger.hilt.android.plugin")
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
        // Or, if you prefer, you can continue to check for errors in release builds,
        // but continue the build even when errors are found:
//        abortOnError false
    }
}
// Allow references to generated code
//kapt {
//    correctErrorTypes = true
//}

repositories {
    maven { url = uri("https://jitpack.io") }
/*flatDir{
        dirs = dirs("libs")
    }*/

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
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
//    implementation(Dependency.Dependance.hiltDagger)
//    kapt(Dependency.Dependance.hiltKotlinCompiler)

}
