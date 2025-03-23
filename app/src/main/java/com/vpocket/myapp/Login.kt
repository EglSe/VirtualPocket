package com.vpocket.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vpocket.R

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sujungimas su login.xml
        setContentView(R.layout.login)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.prisijungimas)

        // Prisijungti mygtuko paspaudimo apdorojimas
        loginButton.setOnClickListener {

            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Patikrinti ar laukeliai uzpildyti
            if (email.isEmpty() || password.isEmpty()) {
                //jei laukeliai tusti
                Toast.makeText(this, "Prašome užpildyti visus laukus", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Jei duomenys teisingi atidarom ParentMain langa
            val intent = Intent(this, ParentMain::class.java)
            startActivity(intent)

            // Uzdarome Login langa
            finish()
        }

        //registracijos mygtukas
        val registracijaButton = findViewById<Button>(R.id.registracija)

        registracijaButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}