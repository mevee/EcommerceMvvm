object Dependency {
    private const val kotlinGradlePluginVersion = "1.5.31"
    private const val gradleVersion = "4.2.1"
    private const val servicesVersion = "4.3.4"
     private const val hiltVersion = "2.37"

    private const val LIVE_DATA_VERSION = "2.3.1"
    private const val Co_Routine_VERSION = "1.4.3"
    private const val navigationVersion = "2.3.5"

    object Project {
        const val androidGradle = "com.android.tools.build:gradle:$gradleVersion"
        const val googleServices = "com.google.gms:google-services:$servicesVersion"
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinGradlePluginVersion"

    }

    object Android {
        const val compileSdkVersion = 29
        const val buildToolsVersion = "29.0.2"
        const val applicationId = "com.webkype.happiroo"
        const val minSdkVersion = 21
        const val targetSdkVersion = 29
        const val versionCode = 8
        const val versionName = "1.8"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    object Dependance {
        const val circleimageview ="de.hdodenhof:circleimageview:3.0.0"
        const val PhotoView = "com.github.chrisbanes:PhotoView:1.3.0"
        const val circleindicator = "me.relex:circleindicator:1.2.2@aar"
        const val OtpView = "com.github.aabhasr1:OtpView:v1.0.5"
        const val material = "com.google.android.material:material:1.1.0"
        const val constraintlayout ="androidx.constraintlayout:constraintlayout:1.1.3"
        const val razerPay ="com.razorpay:checkout:1.5.16"

        const val hiltDagger ="com.google.dagger:hilt-android:$hiltVersion"
        const val hiltKotlinCompiler ="com.google.dagger:hilt-android-compiler:$hiltVersion"

        const val lifecycleliveData  ="androidx.lifecycle:lifecycle-livedata-ktx:$LIVE_DATA_VERSION"
        const val lifecycleViewModel ="androidx.lifecycle:lifecycle-viewmodel-ktx:$LIVE_DATA_VERSION"
        const val lifecycleRuntime   ="androidx.lifecycle:lifecycle-runtime-ktx:$LIVE_DATA_VERSION"

        const val coroutinesCore   ="org.jetbrains.kotlinx:kotlinx-coroutines-core:$Co_Routine_VERSION"
        const val coroutinesAndroid   ="org.jetbrains.kotlinx:kotlinx-coroutines-android:$Co_Routine_VERSION"

        const val navigationFragment   ="androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        const val navigationUi   ="androidx.navigation:navigation-ui-ktx:$navigationVersion"
         const val kotlinStdLib ="org.jetbrains.kotlin:kotlin-stdlib:$kotlinGradlePluginVersion"



    }

}