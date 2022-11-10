package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //vinculacion a la siguiente pagina
    public void Ingresar(View v){
        Intent ingre = new Intent(this, ingreso_de_usuario.class);
        startActivity(ingre);
    }
}