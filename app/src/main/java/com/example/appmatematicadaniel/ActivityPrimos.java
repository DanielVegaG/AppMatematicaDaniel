package com.example.appmatematicadaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityPrimos extends AppCompatActivity {
    //variables
    private EditText n1;
    private TextView eRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primos);

        n1 = findViewById(R.id.etNPrimo);
        eRes = findViewById(R.id.etResultadoPrimos);
    }

    //este método devuelve si un número es primo o no
    public void Primos(View view) {
        String n=n1.getText().toString();
        //se controla que el EditText no esté vacío
        if(n.equals("")!=true){
            int numero = Integer.parseInt(n);
            int contador = 2;
            boolean primo = true;
            while ((primo) && (contador != numero)) {
                if (numero % contador == 0)
                    primo = false;
                contador++;
            }
            String res="";//string que se pasa por parámetro al siguiente método que dice si es primo o no
            if(primo==true){
                res="Sí";
            }else{
                res="No";
            }
            //se llama al método "resultadosPrimos" de la clase Resultados que muestra en el TextView los últimos 5 resultados
            Resultados.resultadosPrimos(numero, res, eRes);
        }else{
            //da un aviso si el EditText está vacío
            Toast.makeText(this, "El campo del valor no debe estar vacío", Toast.LENGTH_SHORT).show();
        }
    }

    //este método hace que vuelva a la actividad principal
    public void volver(View view){
        finish();
    }
}