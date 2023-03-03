package com.test.mlangsupporttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class UserLogoutActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_logout)
        button = findViewById(R.id.tap_me)

        button.setOnClickListener {
                val userTest = Intent(this, TestActivity :: class.java)
                //userHome.putExtra("username", usernameText.text.toString())
                //userHome.putExtra("selectedItemPosition", languageList[spinner.selectedItemPosition])
                startActivity(userTest)

        }

    }
}