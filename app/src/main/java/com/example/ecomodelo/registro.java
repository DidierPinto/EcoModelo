package com.example.ecomodelo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class registro extends AppCompatActivity {

    private EditText nombre;
    private EditText email;
    private EditText password;
    private EditText repeatPassword;
    private Button botonRegistro;
    private boolean terminosTyC;
    private boolean datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.editTextText2);
        email = findViewById(R.id.editTextText3);
        password = findViewById(R.id.editTextText4);
        repeatPassword = findViewById(R.id.editTextText5);
        botonRegistro = findViewById(R.id.button3);



        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });

    }

    private void registrarUsuario() {

        String nombreN = nombre.getText().toString().trim();
        String correoN = email.getText().toString().trim();
        String contrasenaN = password.getText().toString().trim();
        String repetirP = repeatPassword.getText().toString().trim();

        terminosTyC = ((CheckBox) findViewById(R.id.checkBox2)).isChecked();
        datos = ((CheckBox) findViewById(R.id.checkBox)).isChecked();

        if(nombreN.isEmpty() || correoN.isEmpty() || contrasenaN.isEmpty() || repetirP.isEmpty()){
            Toast.makeText(this, "Por favor completar los datos", Toast.LENGTH_SHORT).show();
        }else{
            if(!contrasenaN.equals(repetirP)){
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }else{
                Usuario usuario = new Usuario(nombreN, correoN, contrasenaN);

                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            }
        }

    }
}