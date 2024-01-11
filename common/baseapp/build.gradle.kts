plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

android {
  namespace = "com.quintallabs.common.baseapp"
  compileSdk = 33

  defaultConfig {
    minSdk = 28

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

dependencies {

  api("androidx.core:core-ktx:1.12.0")
  api("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  api("androidx.activity:activity-compose:1.8.2")
  api(platform("androidx.compose:compose-bom:2023.03.00"))
  api("androidx.compose.ui:ui")
  api("androidx.compose.ui:ui-graphics")
  api("androidx.compose.ui:ui-tooling-preview")
  api("androidx.compose.material3:material3")
  api("androidx.compose.material:material:1.5.4")
  api("androidx.navigation:navigation-compose:2.7.6")

  api("io.insert-koin:koin-core:3.5.3")
  api("io.insert-koin:koin-android:3.5.3")
  api("io.insert-koin:koin-android-compat:3.5.3")
  api("io.insert-koin:koin-androidx-workmanager:3.5.3")
  api("io.insert-koin:koin-androidx-navigation:3.5.3")
  api("io.insert-koin:koin-androidx-compose:3.5.3")

  api("com.squareup.retrofit2:retrofit:2.9.0")
  api("com.squareup.retrofit2:converter-gson:2.9.0")
  api("com.squareup.okhttp3:logging-interceptor:3.12.0")
  api("com.google.code.gson:gson:2.9.0")
  api("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

  api("io.coil-kt:coil-compose:2.4.0")

  api("io.github.pilgr:paperdb:2.7.2")

  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")

  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
}