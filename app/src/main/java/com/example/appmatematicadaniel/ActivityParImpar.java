package com.example.appmatematicadaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityParImpar extends AppCompatActivity {
    //variables
    private EditText n1;
    private TextView eRes;
    private RadioButton rbPar, rbImpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_impar);

        n1 = findViewById(R.id.etN1);
        eRes = findViewById(R.id.tvResultadoParImpar);
        rbPar=findViewById(R.id.rbPar);
        rbImpar=findViewById(R.id.rbImpar);
    }

    //este método devuelve si el número del EditText es par o impar
    public void ParImpar(View view){
        String num=n1.getText().toString();
        if(num.equals("")!=true){
            int numero = Integer.parseInt(num);
            //se llama al método "resultadosParImpar" de la clase Resultados para que se guarden los 5 últimos resultados
            Resultados.resultadosParImpar(numero, rbPar, rbImpar, eRes);
        }else{
            //da un aviso si el campo está vacío
            Toast.makeText(this, "El campo del número no puede estar vacío", Toast.LENGTH_SHORT).show();
        }
        Log.d("Botón","Ha pasado por el botón para saber si es par o impar");
    }

    //este método hace que vuelva a la actividad principal
    public void volver(View view){
        finish();
    }
}