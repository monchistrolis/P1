package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class solicitar_credito extends AppCompatActivity {
    private TextView vistaNombre,TxNombre,TxApellido,TxMonto;
    private TextView TvResultado;
    private Spinner spEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_credito);

        vistaNombre = findViewById(R.id.twNom_user);
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("nombre");
        vistaNombre.setText(nombre);

        TxNombre = findViewById(R.id.inNombre);
        TxApellido = findViewById(R.id.inApellido);
        TxMonto = findViewById(R.id.inMonto);
        spEleccion = findViewById(R.id.opCuotas);
        //gualdar resultado


        //creacion del array de opciones
        String[] opciones = {"Seleccione", String.valueOf(5), String.valueOf(10), String.valueOf(15), String.valueOf(20), String.valueOf(25), String.valueOf(30)};
        //generar el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        //genera la opcion
        spEleccion.setAdapter(adapter);
    }

    public void EnviarCredito(View v){
        if
        (TxNombre.getText().toString().isEmpty() || TxApellido.getText().toString().isEmpty() ||
                TxMonto.getText().toString().isEmpty() || spEleccion.getSelectedItem().toString().equals("Seleccione")){
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(this, resultado_credito.class);
            i.putExtra("nombre", TxNombre.getText().toString());
            i.putExtra("apellido", TxApellido.getText().toString());
            i.putExtra("monto", TxMonto.getText().toString());
            i.putExtra("cuotas", spEleccion.getSelectedItem().toString());
            startActivity(i);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.op1:
                if (TxNombre.getText().toString().equals("")){
                    Toast.makeText(this, "No hay datos para mostrar", Toast.LENGTH_SHORT).show();
                }else{
                    Intent ResultadoCredito = new Intent(this,solicitar_credito.class);
                    Toast.makeText(this, "Resultado de Credito", Toast.LENGTH_SHORT).show();
                    startActivity(ResultadoCredito);
                }
                break;
            case R.id.op2:
                BreakIterator tvNombre;
                if(TxNombre.getText().toString().equals("")){
                    Toast.makeText(this, "No hay datos para mostrar", Toast.LENGTH_SHORT).show();
                }else{
                    Intent ResultadoCredito = new Intent(this, resultado_credito.class);
                    Toast.makeText(this, "Resultado de Credito", Toast.LENGTH_SHORT).show();
                    startActivity(ResultadoCredito);
                }
                break;
            case R.id.op3:
                Intent salir = new Intent(this, MainActivity.class);
                Toast.makeText(this, "Has Salido", Toast.LENGTH_SHORT).show();
                startActivity(salir);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
