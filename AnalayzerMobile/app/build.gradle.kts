
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.analayzermobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.analayzermobile"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // Compose
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.3")
    implementation(platform("androidx.compose:compose-bom:2024.02.02"))
    implementation("androidx.compose.ui:ui:1.6.3")
    implementation("androidx.compose.foundation:foundation:1.6.3")
    implementation("androidx.compose.material:material:1.6.3")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.ui:ui-graphics:1.6.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.0.5")
    implementation("androidx.compose.ui:ui-tooling:1.1.1")

    //Corrutinas
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.46")
    kapt("com.google.dagger:hilt-android-compiler:2.46")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.drawerlayout:drawerlayout:1.2.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.test:core-ktx:1.5.0")
    implementation("com.google.android.gms:play-services-mlkit-text-recognition-common:19.0.0")
    implementation("com.google.firebase:firebase-inappmessaging-ktx:20.4.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Compose
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Room
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

}

kapt{
    correctErrorTypes = true
}
