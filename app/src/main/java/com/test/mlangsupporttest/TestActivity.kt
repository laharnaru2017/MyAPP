package com.test.mlangsupporttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val firstFragment = FragmentOne()
        supportFragmentManager.beginTransaction().replace(R.id.test, firstFragment)
            .commit()
    }
}