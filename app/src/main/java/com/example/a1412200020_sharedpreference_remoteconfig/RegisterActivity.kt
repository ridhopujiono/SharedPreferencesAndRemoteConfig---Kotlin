package com.example.a1412200020_sharedpreference_remoteconfig

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a1412200020_sharedpreference_remoteconfig.databinding.RegisterActivityBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: RegisterActivityBinding;
    private lateinit var nameEntered: EditText
    private lateinit var emailEntered: EditText
    private lateinit var phoneNumberEntered: EditText
    private lateinit var BPJSEntered: EditText
    private lateinit var usernameEntered: EditText
    private lateinit var passwordEntered: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        var binding: RegisterActivityBinding = RegisterActivityBinding.inflate(layoutInflater)

        setContentView(binding.root);


        binding.buttonRegister.setOnClickListener {
            nameEntered = binding.editTextNamaLengkap;
            emailEntered = binding.editTextEmail;
            phoneNumberEntered = binding.editTextNomorPonsel;
            BPJSEntered = binding.editTextBPJS;
            usernameEntered = binding.editTextUsername
            passwordEntered = binding.editTextPassword

            val sharedPreferences = this.getSharedPreferences("user", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("name", nameEntered.text.toString())
            editor.putString("email", emailEntered.text.toString())
            editor.putString("phone", phoneNumberEntered.text.toString())
            editor.putString("bpjs", BPJSEntered.text.toString())
            editor.putString("username", usernameEntered.text.toString())
            editor.putString("password", passwordEntered.text.toString())
            editor.apply()

            Toast.makeText(this, "Registrasi berhasil! Silahkan Login", Toast.LENGTH_LONG).show()
            //  reset
            nameEntered.setText("")
            emailEntered.setText("")
            phoneNumberEntered.setText("")
            BPJSEntered.setText("")
            usernameEntered.setText("")
            passwordEntered.setText("")
        }

        binding.buttonKembali.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}