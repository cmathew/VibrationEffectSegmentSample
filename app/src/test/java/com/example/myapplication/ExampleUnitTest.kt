package com.example.myapplication

import android.os.Build
import androidx.test.core.app.ApplicationProvider
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @Test
    @Config(sdk = [Build.VERSION_CODES.O])
    fun getVibrator_26() {
        VibratorCompat.getDefaultVibrator(ApplicationProvider.getApplicationContext())
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S_V2])
    fun getVibrator_32() {
        VibratorCompat.getDefaultVibrator(ApplicationProvider.getApplicationContext())
    }
}