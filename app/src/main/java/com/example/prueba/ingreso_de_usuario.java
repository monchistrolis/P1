package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ingreso_de_usuario extends AppCompatActivity {
    private EditText etNombre;
    private EditText etContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_de_usuario);

        etNombre = findViewById(R.id.inUser);
        etContraseña = findViewById(R.id.inContraseña);
    }
    public void Ingresar2(View v){
        //validada la entrada de datos
        if (etNombre.getText().toString().isEmpty() || etContraseña.getText().toString().isEmpty()){
            etNombre.setError("Ingrese su nombre");
            etContraseña.setError("Ingrese su contraseña");
        }else{
            Intent i = new Intent(this, solicitar_credito.class);
            i.putExtra("nombre", etNombre.getText().toString());
            startActivity(i);
        }
        //Intent ingresar = new Intent(this, solicitar_credito.class);
        //ingresar.putExtra("nombre", etNombre.getText().toString());
        //startActivity(ingresar);
    }
}