package com.example.giuaky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class singnup : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var repeatpassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var db: DBhealper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singnup)

        email = findViewById(R.id.edtEmail)
        username = findViewById(R.id.edtName)
        password = findViewById(R.id.edtPass)
        repeatpassword = findViewById(R.id.edtRepeatPass)
        btnRegister = findViewById(R.id.btnRegister)
        db = DBhealper(this)

        btnRegister.setOnClickListener {
            val emailtext = email.text.toString()
            val usernametext = username.text.toString()
            val passtext = password.text.toString()
            val repass = repeatpassword.text.toString()
            val savedata = db.insertData(emailtext,usernametext,passtext)

            if (TextUtils.isEmpty(emailtext) ||TextUtils.isEmpty(usernametext) || TextUtils.isEmpty(passtext)  ){
                Toast.makeText(this, "Add email username pass", Toast.LENGTH_SHORT).show()
            } else if (passtext.equals(repass)) {
                if (savedata) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Signup successed!!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "User exists", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Password Not match", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
