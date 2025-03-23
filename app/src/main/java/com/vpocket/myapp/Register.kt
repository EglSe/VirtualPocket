package com.vpocket.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vpocket.R

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registracija) //  XML failas registracija

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password1)
        val confirmPasswordEditText = findViewById<EditText>(R.id.password2)
        val registerButton = findViewById<Button>(R.id.registracija_button)
        val backButton = findViewById<Button>(R.id.atgal_button)

        // Registracijos mygtuko paspaudimas

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Prašome užpildyti visus laukus!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Slaptažodžiai nesutampa!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //  neigyvendintas registracijos funkcionalumas, reikia firebase
            Toast.makeText(this, "Registracija atlikta", Toast.LENGTH_SHORT).show()

            // Pereiname i Login langa jei registracija sekminga
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

        // Grižimas į prisijungimo langą
        backButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}