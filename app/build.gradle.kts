plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    id ("kotlin-kapt")
}

android {
    namespace = "com.testemobile.githubjava"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.testemobile.githubjava"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }
}

dependencies {

    // Koin for Android
    implementation ("io.insert-koin:koin-android:3.4.0")


    //DEPENDENCIAS COMUNS ANDROID
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")

    //DEPENDENCIAS COMUNICACAO WEB
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation( "com.squareup.retrofit2:adapter-rxjava2:2.3.0")

    //BANCO E DADOS ROOM
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    //RX
    implementation("com.jakewharton.rxbinding2:rxbinding:2.0.0")
    implementation ("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation ("io.reactivex.rxjava2:rxjava:2.1.1")


    //DEPENDENCIAS DE TESTE
    testImplementation("junit:junit:4.13.2")
    implementation("org.mockito:mockito-core:5.8.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //CARREGAMENTO DE IMAGEM
    implementation("io.coil-kt:coil:2.5.0")

}