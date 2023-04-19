package com.example.appmatematicadaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.ToggleButton;

public class ActivityFormulasMatematicas extends AppCompatActivity {
    //variables
    private ToggleButton tbForms;
    private LinearLayout lForms;

    private CheckBox cbA, cbV, cbF;
    private TableLayout tlA, tlV, tlF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas_matematicas);

        tbForms=findViewById(R.id.tbForms);
        lForms=findViewById(R.id.lForms);

        cbA=findViewById(R.id.cbArea);
        cbV=findViewById(R.id.cbVolumenes);
        cbF=findViewById(R.id.cbFunciones);

        tlA=findViewById(R.id.tlAreas);
        tlV=findViewById(R.id.tlVolumenes);
        tlF=findViewById(R.id.tlFormulas);

    }

    //este método oculta y muestra el contenido de la activity
    public void ocultarMostrarTodo(View view){
        if(tbForms.isChecked()==true){
            lForms.setVisibility(view.VISIBLE);
        }else{
            lForms.setVisibility(view.GONE);
        }
    }

    //este método muestra y oculta el layout de las áreas
    public void mostrarAreas(View view){
        if(cbA.isChecked()==true){
            tlA.setVisibility(view.VISIBLE);
        }else{
            tlA.setVisibility(view.GONE);
        }
    }

    //este método muestra y oculta el layout de los volúmenes
    public void mostrarVolumenes(View view){
        if(cbV.isChecked()==true){
            tlV.setVisibility(view.VISIBLE);
        }else{
            tlV.setVisibility(view.GONE);
        }
    }

    //este método muestra y oculta el layout de las fórmulas
    public void mostrarFormulas(View view){
        if(cbF.isChecked()==true){
            tlF.setVisibility(view.VISIBLE);
        }else{
            tlF.setVisibility(view.GONE);
        }
    }

    //este método lleva a una página en la que salen más fórmulas de áreas
    public void másÁreas(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.superprof.es/apuntes/escolar/matematicas/geometria/espacio/formulas-de-areas.html"));
        startActivity(i);
    }

    //este método lleva a una página en la que salen más fórmulas de volúmenes
    public void másVolúmenes(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.superprof.es/apuntes/escolar/matematicas/geometria/espacio/formulas-de-areas-y-volumenes.html"));
        startActivity(i);
    }

    //este método lleva a una página en la que salen más fórmulas en general
    public void másFórmulas(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.superprof.es/apuntes/escolar/matematicas/algebra/ecuaciones/formulas-de-la-ecuacion-de-segundo-grado.html"));
        startActivity(i);
    }

    //este método hace que vuelva a la actividad principal
    public void volver(View view){
        finish();
    }
}