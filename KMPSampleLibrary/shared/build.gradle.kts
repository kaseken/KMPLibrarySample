import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
}

kotlin {
  androidTarget {
    compilations.all {
      compileTaskProvider.configure { compilerOptions { jvmTarget.set(JvmTarget.JVM_1_8) } }
    }
  }

  val xcf = XCFramework("KMPSampleLibrary")
  listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach {
    it.binaries.framework {
      baseName = "KMPSampleLibrary"
      xcf.add(this)
    }
  }

  sourceSets {
    commonMain.dependencies {
      // put your multiplatform dependencies here
    }
    commonTest.dependencies { implementation(libs.kotlin.test) }
  }
}

android {
  namespace = "dev.kaseken.kmpsamplelibrary"
  compileSdk = 35
  defaultConfig { minSdk = 29 }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}
