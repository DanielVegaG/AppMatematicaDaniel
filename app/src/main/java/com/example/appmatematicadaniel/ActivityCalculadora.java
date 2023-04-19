package com.example.appmatematicadaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCalculadora extends AppCompatActivity {
    //variables
    private String valor1, valor2;
    private TextView etiquetaRes;

    private Switch sCalc;
    private LinearLayout llCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //dar valor a variables
        Bundle b = getIntent().getExtras();
        valor1 = b.getString("valor1");
        valor2 = b.getString("valor2");

        etiquetaRes = findViewById(R.id.etiquetaRes);

        sCalc = findViewById(R.id.sCalc);
        llCalc = findViewById(R.id.llCalc);
    }

    //métodos
    //enciende la calculadora al encender un switch
    public void encenderCalculadora(View view) {
        if (sCalc.isChecked() == true) {
            llCalc.setVisibility(View.VISIBLE);
        } else {
            llCalc.setVisibility(View.GONE);
        }
    }

    //realiza la suma de los dos números
    public void sumar(View view) {
        int op1 = Integer.parseInt(valor1);
        int op2 = Integer.parseInt(valor2);

        /*if ((op1>=10)&& (op2>=10)){
         int res=op1+op2;
         etiquetaRes.setText("Resultado suma: "+ res);
         } else{
         Toast.makeText(this, "Recuerda que los valores deben ser mínimo 10", Toast.LENGTH_SHORT);
         }*/
        int res = op1 + op2;
        etiquetaRes.setText("Resultado suma: " + res);
    }

    //realiza la resta de los dos números
    public void restar(View view) {
        int op1 = Integer.parseInt(valor1);
        int op2 = Integer.parseInt(valor2);
        int res = op1 - op2;
        etiquetaRes.setText("Resultado resta: " + res);
    }

    //realiza la multiplicación de los dos números
    public void multiplicar(View view) {
        int op1 = Integer.parseInt(valor1);
        int op2 = Integer.parseInt(valor2);
        int res = op1 * op2;
        etiquetaRes.setText("Resultado multiplicación: " + res);
    }

    //realiza la división de los dos números
    public void dividir(View view) {
        float op1 = Float.parseFloat(valor1);
        float op2 = Float.parseFloat(valor2);

        if (op2 != 0) {
            float res = op1 / op2;
            etiquetaRes.setText("Resultado división: " + res);
        } else {
            Toast.makeText(this, "Imposible dividir entre 0", Toast.LENGTH_SHORT).show();
        }

    }

    //realiza la potencia de los dos números
    public void potencia(View view) {
        double op1 = Double.parseDouble(valor1);
        double op2 = Double.parseDouble(valor2);
        double res = Math.pow(op1, op2);
        etiquetaRes.setText("Resultado potencia: " + res);
    }


    //este método hace que vuelva a la actividad principal
    public void volver(View view) {
        finish();
    }
}