plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.aguas"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.aguas"
        minSdk = 28
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
}

// Configuración de la generación de documentación con Dokka
tasks.dokkaJavadoc.configure {
    outputDirectory.set(file("../documentation/Javadoc")) // Directorio de salida para la documentación Javadoc
}
tasks.dokkaHtml.configure {
    outputDirectory.set(file("../documentation/html")) // Directorio de salida para la documentación HTML
}

tasks.dokkaGfm.configure {
    outputDirectory.set(file("../documentation/Gfm")) // Directorio de salida para la documentación GFM
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //implementacion de google con gson
    implementation("com.google.code.gson:gson:2.10.1")


    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Dependencias para pruebas
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:3.11.2")
    androidTestImplementation ("androidx.test:rules:1.5.0")

    //APi de gatos
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("com.squareup.picasso:picasso:2.71828")

    //
    implementation ("androidx.room:room-runtime:2.4.2")
    //kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.4.2")


}