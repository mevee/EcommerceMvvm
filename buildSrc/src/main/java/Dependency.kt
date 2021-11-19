object Dependency {
    private const val gradleVersion = "4.2.1"
    private const val servicesVersion = "4.3.4"
    private const val HILT_DAGGERVersion = "2.38.1"

    object Project {
        const val gradle = "com.android.tools.build:gradle:$gradleVersion"
        const val googleServices = "com.google.gms:google-services:$servicesVersion"
        const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:$HILT_DAGGERVersion"
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
        const val hiltDagger ="com.google.dagger:hilt-android:$HILT_DAGGERVersion"
        const val hiltKotlinCompiler ="com.google.dagger:hilt-android-compiler:$HILT_DAGGERVersion"
    }

}