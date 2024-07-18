package com.example.ecomodelo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.editTextText);
        passwordEditText = findViewById(R.id.editTextNumberPassword);
        loginButton = findViewById(R.id.button);
        registerButton = findViewById(R.id.button2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validar las credenciales del usuario
                if (validarCredenciales(email, password)) {
                    // Credenciales válidas, realizar la acción de inicio de sesión
                    iniciarSesion();
                } else {
                    // Credenciales inválidas, mostrar mensaje de error
                    Toast.makeText(Login.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realizar la acción de registro
                registrar();
            }
        });
    }

    private boolean validarCredenciales(String email, String password) {
        Usuario usuarioEjemplo = new Usuario("Didier Pinto", "didieresnaki@hotmail.com", "123456");
        return email.equals(usuarioEjemplo.getCorreo()) && password.equals(usuarioEjemplo.getContrasena());
    }

    private void iniciarSesion() {
        // Aquí puedes implementar la lógica para iniciar sesión.
        // Por ejemplo, puedes abrir una nueva actividad o realizar alguna acción después del inicio de sesión exitoso.
        Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
    }

    private void registrar() {
        Intent Registrar = new Intent(Login.this, registro.class);
        startActivity(Registrar);
        // Por ejemplo, puedes abrir una actividad de registro o mostrar un formulario de registro.
        Toast.makeText(this, "Registro de usuario", Toast.LENGTH_SHORT).show();
    }
}

class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }
}
