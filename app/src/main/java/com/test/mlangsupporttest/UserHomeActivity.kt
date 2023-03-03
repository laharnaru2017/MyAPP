package com.test.mlangsupporttest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class UserHomeActivity : AppCompatActivity() {

    lateinit var myPreference: MyPreference
    lateinit var context: Context
    lateinit var userTextView: TextView
    lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        myPreference = MyPreference(this)
        setContentView(R.layout.activity_user_home)
        userTextView = findViewById(R.id.userTextView)
        logoutButton = findViewById(R.id.logoutButton)

        var username: String? = intent.getStringExtra("username")
        userTextView.setText(username)

        logoutButton.setOnClickListener {
            val loginPage = Intent(this, MainActivity :: class.java)
            startActivity(loginPage)
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        myPreference = MyPreference(newBase!!)
        val lang:String = myPreference.getLoginCount()
        super.attachBaseContext(MyContextWrapper.wrap(newBase, lang))
    }
}