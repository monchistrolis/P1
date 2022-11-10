package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class resultado_credito extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvmontoSolicitadoUF;
    private TextView tvSeguroDesgravamen;
    private TextView tvseguroCIncendio;
    private TextView tvTotalIntereces;
    private TextView tvTotalUF;
    private TextView tvTotalPeso;
    private TextView vistaNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_credito);

        vistaNombre = findViewById(R.id.twNom_user2);
        Bundle datos = getIntent().getExtras();
        String nombre1 = datos.getString("nombre");
        vistaNombre.setText(nombre1);



        tvNombre = findViewById(R.id.twNom_re);
        tvmontoSolicitadoUF = findViewById(R.id.twM_uf);
        tvSeguroDesgravamen = findViewById(R.id.twS_Desgravame);
        tvseguroCIncendio = findViewById(R.id.twS_incendio);
        tvTotalIntereces = findViewById(R.id.teT_intereses);
        tvTotalUF = findViewById(R.id.twT_uf);
        tvTotalPeso = findViewById(R.id.twT_peso);



        //conexion con la otra pagina
        Bundle b = getIntent().getExtras();
        String nombre = b.getString("nombre");
        String apellido=b.getString("apellido");
        String montoSolicitadoUF = b.getString("monto");

        //calculo Monto a uf
        int clp = Integer.parseInt(montoSolicitadoUF);
        int uf = Integer.parseInt(String.valueOf(33000));
        int calUf = clp/uf;
        String UF = String.valueOf(calUf);


        //calculo de seguro desgravamen 10%
        int seguroDesgravamen = (clp*10)/100;

        //calculo de seguro incendio 5%
        int seguroIncendio = (clp*5)/100;


        //calculo de intereses 30%
        int interes1 = (clp*30)/100;
        //calculo de intereses 35%
        int interes2 = (clp*35)/100;
        //calculo de intereses 40%
        int interes3 = (clp*40)/100;

        //total intereses
        int totalIntereses = seguroDesgravamen+seguroIncendio;

        //credito total en clp
        int totalPeso = totalIntereses+clp;

        //credito total en uf
        int totalUf = totalPeso/uf;


        tvNombre.setText("Nombre : " + nombre + apellido);
        tvmontoSolicitadoUF.setText("Monto Solicitado en Uf : "+ calUf);
        tvSeguroDesgravamen.setText("Seguro Desgravamen : "+ seguroDesgravamen);
        tvseguroCIncendio.setText("Seguro Incendio : "+ seguroIncendio);
        tvTotalIntereces.setText("Total Intereses : "+ totalIntereses);
        tvTotalUF.setText("Total Uf : "+ totalUf);
        tvTotalPeso.setText("Total Peso : "+ totalPeso);




    }
    public void Salir(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
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
                Intent SolCredito = new Intent(this, solicitar_credito.class);
                Toast.makeText(this, "Solicitud de Credito", Toast.LENGTH_SHORT).show();
                startActivity(SolCredito);
                break;
            case R.id.op2:
                Intent ResultadoCredito = new Intent(this, resultado_credito.class);
                Toast.makeText(this, "Resultado de Credito", Toast.LENGTH_SHORT).show();
                startActivity(ResultadoCredito);
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