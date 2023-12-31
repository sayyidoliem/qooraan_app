plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    //kts
    kotlin("kapt")
}

android {
    namespace = "com.olimhouse.qooraanapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.olimhouse.qooraanapp"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.09.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.navigation:navigation-compose:2.6.0")


    val roomVersion = "2.5.2"

    implementation("androidx.room:room-runtime:$roomVersion")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$roomVersion")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

    //permission
    implementation("com.google.accompanist:accompanist-permissions:0.23.1")

    //location
    implementation("com.google.android.gms:play-services-location:21.0.1")
    //m3 material library
//    implementation("androidx.compose.material3:material3:1.2.0-alpha08")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //converter gson
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //buat ngerender website di dalam android/aplikasi
    implementation("com.github.Justson.AgentWeb:agentweb-core:v4.1.9-androidx")

//    implementation("androidx.compose.foundation:foundation-android:1.5.3")

    // core
    implementation ("com.chibatching.kotpref:kotpref:2.13.1")

    // optional, auto initialization module
    implementation ("com.chibatching.kotpref:initializer:2.13.1")

    // optional, support saving enum value and ordinal
    implementation ("com.chibatching.kotpref:enum-support:2.13.1")

    //media player
    implementation ("com.github.jrfeng.snow:player:1.2.13")

    //nambahin vector icon klo pake Icons
    implementation ("androidx.compose.material:material-icons-extended:1.5.4")

    //buat asynchronus image
    implementation("io.coil-kt:coil-compose:2.5.0")

    //buat animasi
    implementation ("com.airbnb.android:lottie-compose:6.1.0")

    // For Glance support
    implementation("androidx.glance:glance:1.0.0")

    // For AppWidgets support
    implementation("androidx.glance:glance-appwidget:1.0.0")

    // For interop APIs with Material 3
    implementation ("androidx.glance:glance-material3:1.0.0")


    // For Wear-Tiles support
    implementation("androidx.glance:glance-wear-tiles:1.0.0-alpha05")
}