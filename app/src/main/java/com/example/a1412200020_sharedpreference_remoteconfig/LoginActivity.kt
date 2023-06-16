package com.example.a1412200020_sharedpreference_remoteconfig

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a1412200020_sharedpreference_remoteconfig.databinding.LoginActivityBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var usernameEntered: EditText
    private lateinit var passwordEntered: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: LoginActivityBinding = LoginActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        usernameEntered =  binding.editTextUsername
        passwordEntered = binding.editTextPassword
        val buttonLogin: Button = binding.buttonLogin
        val buttonRegister: TextView = binding.buttonRegister

        buttonLogin.setOnClickListener {
            val sharedPreferences = this.getSharedPreferences("user", Context.MODE_PRIVATE)
            val usernameSaved: String? = sharedPreferences.getString("username", "")
            val passwordSaved: String? = sharedPreferences.getString("password", "")

            if(usernameEntered.text.toString() == usernameSaved && passwordEntered.text.toString() == passwordSaved){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
        buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}
