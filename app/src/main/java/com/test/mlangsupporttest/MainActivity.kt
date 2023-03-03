package com.test.mlangsupporttest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var myPreference: MyPreference
    lateinit var context: Context
    lateinit var spinner: Spinner
    lateinit var changeLangButton: Button
    lateinit var loginButton: Button
    lateinit var usernameText: TextView
    lateinit var passwordText: TextView

    val languageList = arrayOf("en","hi","bn")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        myPreference = MyPreference(this)
        spinner = findViewById(R.id.spinner)
        changeLangButton = findViewById(R.id.changeLangButton)
        loginButton = findViewById(R.id.loginButton)
        usernameText = findViewById(R.id.usernameText)
        passwordText = findViewById(R.id.passwordText)

        spinner.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, languageList)

        val lang = myPreference.getLoginCount()
        val index = languageList.indexOf(lang)
        if(index >= 0){
            spinner.setSelection(index)
        }

        loginButton.setOnClickListener {
            if (usernameText.text.toString() != "" && passwordText.text.toString() != "") {
                val userHome = Intent(this, UserLogoutActivity :: class.java)
                //userHome.putExtra("username", usernameText.text.toString())
                //userHome.putExtra("selectedItemPosition", languageList[spinner.selectedItemPosition])
                startActivity(userHome)
            }
        }

        changeLangButton.setOnClickListener {
            myPreference.setLoginCount(languageList[spinner.selectedItemPosition])
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        myPreference = MyPreference(newBase!!)
        val lang:String = myPreference.getLoginCount()
        super.attachBaseContext(MyContextWrapper.wrap(newBase, lang))
    }
}