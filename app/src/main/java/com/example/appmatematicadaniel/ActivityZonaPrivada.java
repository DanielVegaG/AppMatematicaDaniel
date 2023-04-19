package com.example.appmatematicadaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ActivityZonaPrivada extends AppCompatActivity {
    //variables
    private ToggleButton tbZonaPrivada;
    private Switch swZonaPrivada;
    private LinearLayout llZonaPrivada, llZonaPrivadaSwitch;
    private TextView tvZonaPrivada;
    private RadioButton rb10,rbOtro10,rbSuspenso,rbObvio10;
    private ImageButton ibPrivada;

    //spinner
    private Spinner spinnerNotas;
    private String[] notas={"Van bien, de momento todos aprobados",
            "Todos suspensos, hay que quedarse en marzo",
            "Mejor de lo esperado, lo mínimo es un 8",
            "Ha habido mejores grupos pero también peores"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona_privada);

        tbZonaPrivada=findViewById(R.id.tbZonaPrivada);
        swZonaPrivada=findViewById(R.id.swZonaPrivada);
        llZonaPrivada=findViewById(R.id.llZonaPrivada);
        llZonaPrivadaSwitch=findViewById(R.id.llZonaPrivadaSwitch);
        tvZonaPrivada=findViewById(R.id.tvZonaPrivada);
        rb10=findViewById(R.id.rb10);
        rbOtro10=findViewById(R.id.rbOtro10);
        rbSuspenso=findViewById(R.id.rbSuspenso);
        rbObvio10=findViewById(R.id.rbObvio10);
        ibPrivada=findViewById(R.id.ibPrivada);

        //spinner
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, notas);
        spinnerNotas =findViewById(R.id.spinnerNotas);
        spinnerNotas.setAdapter(adaptador);
    }

    //hace visible el switch si está activado el toggleButtton y lo hace invisible si se apaga
    public void verToggleButton(View view){
        if(tbZonaPrivada.isChecked()){
            llZonaPrivadaSwitch.setVisibility(view.VISIBLE);
            tvZonaPrivada.setVisibility(view.GONE);
        }else{
            llZonaPrivadaSwitch.setVisibility(view.GONE);
            tvZonaPrivada.setVisibility(view.VISIBLE);
            swZonaPrivada.setChecked(false);
        }
    }

    //hace visible el resto de la actividad si está activado el switch y lo hace invisible si se apaga
    public void verSwitch(View view){
        if(swZonaPrivada.isChecked()){
            llZonaPrivada.setVisibility(view.VISIBLE);
        }else{
            llZonaPrivada.setVisibility(view.GONE);
        }
    }

    /*si está seleccionada la opción del suspenso desaparece el botón de salir
    y vuelve a aparecer si se selecciona cualquier otra opción
     */
    public void tenerUn10(View view){
        if(rb10.isChecked() || rbOtro10.isChecked() || rbObvio10.isChecked()){
            ibPrivada.setVisibility(view.VISIBLE);
        }else if(rbSuspenso.isChecked()){
            ibPrivada.setVisibility(view.GONE);
        }
    }


    //este método hace que vuelva a la actividad principal mostrando un mensaje de alerta
    public void volver(View view){
        new AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Seguro de que quieres salir de la prestigiosa zona privada?")
                .setPositiveButton("Claro", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        finish();
                    }
                })
                .setNegativeButton("No, me confundí", null)
                .show();
    }

}