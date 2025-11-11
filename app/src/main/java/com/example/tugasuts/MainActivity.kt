package com.example.tugasuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Penyesuaian insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil input
        val editUsername = findViewById<EditText>(R.id.editUsername)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editFirstName = findViewById<EditText>(R.id.editFirstName)
        val editLastName = findViewById<EditText>(R.id.editLastName)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnCancel = findViewById<TextView>(R.id.btnCancel)

        // Data akun login (bisa kamu ganti)
        val validUsername = "firdan"
        val validPassword = "12345"

        // Tombol Login (Kirim)
        btnSubmit.setOnClickListener {
            val username = editUsername.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password wajib diisi!", Toast.LENGTH_SHORT).show()
            } else if (username == validUsername && password == validPassword) {
                Toast.makeText(this, "Login Berhasil! Selamat datang, $username", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_LONG).show()
            }
        }

        // Tombol Batal (reset semua)
        btnCancel.setOnClickListener {
            editUsername.text.clear()
            editEmail.text.clear()
            editFirstName.text.clear()
            editLastName.text.clear()
            editPassword.text.clear()
            Toast.makeText(this, "Form dibersihkan", Toast.LENGTH_SHORT).show()
        }
    }
}
