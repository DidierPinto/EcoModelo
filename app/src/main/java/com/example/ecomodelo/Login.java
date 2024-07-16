package com.example.ecomodelo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button logindButton;
    private Button registroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        emailEditText = findViewById(R.id.editTextText);
        passwordEditText = findViewById(R.id.editTextNumberPassword);
        logindButton = findViewById(R.id.button);
        registroButton = findViewById(R.id.button2);

        logindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();


                if(validarCredenciales(email, password)){
                    iniciarSesion();

                }else{
                    Toast.makeText(Login.this, "Credenciales Invalidas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registro();
            }
        });


    }

    private void registro() {
        Intent registrar = new Intent(Login.this, registro.class);
        startActivity(registrar);

        Toast.makeText(this, "Registro Usuario", Toast.LENGTH_SHORT).show();

    }

    private void iniciarSesion() {
        Toast.makeText(this, "Inicio de sesion Exitoso",Toast.LENGTH_SHORT).show();

    }

    private boolean validarCredenciales(String email, String password) {

        Usuario usuaerioEjemplo = new Usuario("Nombre Ejemplo", "todosalaU@gnai.com", "1234");

        return email.equals(usuaerioEjemplo.getCorreo() && password.equals(usuaerioEjemplo.getContrasena));

    }
}