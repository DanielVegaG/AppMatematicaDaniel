package com.example.appmatematicadaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ActivityNumRandom extends AppCompatActivity {
    //variables
    private EditText etNumInicial;
    private EditText etNumFinal;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_random);

        etNumInicial=findViewById(R.id.etNInicial);
        etNumFinal=findViewById(R.id.etNFinal);
        tvRes=findViewById(R.id.tvRes);
    }

    //este método genera un número aleatrio entre dos números
    public void aleatorio(View view){
        String n1=etNumInicial.getText().toString(), n2=etNumFinal.getText().toString();
        if(n1.equals("")!=true && n2.equals("")!=true){
            int ni=Integer.parseInt(n1);
            int nf=Integer.parseInt(n2);

            if(ni<nf){
                Random r = new Random();
                int res=r.nextInt((nf - ni) + 1) + ni;

                //se llama al método "resultadosNRandom" de la clase Resultados para que se guarden los 5 últimos resultados
                Resultados.resultadosNRandom(ni,nf,res,tvRes);
            }else{
                //da un aviso si el número inicial es mayor que el final
                Toast.makeText(this, "El número inicial debe ser menor que el final", Toast.LENGTH_SHORT).show();
            }
        }else{
            //da un aviso si alguno de los campos está vacío
            Toast.makeText(this, "Ninguno de los valores puede estar vacío", Toast.LENGTH_SHORT).show();
        }

    }

    //este método hace que vuelva a la actividad principal
    public void volver(View view){
        finish();
    }
}