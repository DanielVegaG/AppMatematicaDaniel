package com.example.appmatematicadaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText valor1, valor2, etUser, etPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1=findViewById(R.id.etValor1);
        valor2=findViewById(R.id.etValor2);
        etUser=findViewById(R.id.etUsuario);
        etPw=findViewById(R.id.etPassword);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //este método sirve para que funcione el menú que se desplega pulsando los 3 puntos
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.menu_aleatorios:
                random(null);
                break;
            case R.id.menu_forms:
                formulas(null);
                break;
            case R.id.menu_acercaDe:
                acercaDe(null);
                break;
            case R.id.menu_salir:
                salir(null);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //este método abre la activity "calculadora"
    public void calculadora(View view){
        Intent i=new Intent(this, ActivityCalculadora.class);
        String n1=valor1.getText().toString();
        String n2=valor2.getText().toString();

        if(n1.equals("")!=true && n2.equals("")!=true){
            Bundle b = new Bundle();
            b.putString("valor1",n1);
            b.putString("valor2",n2);
            i.putExtras(b);
            startActivity(i);
        }else {
            Toast.makeText(this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
        }
    }

    //este método abre la activity "num_random"
    public void random(View view){
        Intent i=new Intent(this, ActivityNumRandom.class);
        startActivity(i);
    }

    //este método abre la activity "formulas_matematicas"
    public void formulas(View view){
        Intent i=new Intent(this, ActivityFormulasMatematicas.class);
        startActivity(i);
    }

    //este método abre la activity "par_impar"
    public void parImpar(View view){
        Intent i=new Intent(this, ActivityParImpar.class);
        startActivity(i);
    }

    //este método abre la activity "primos"
    public void primos(View view){
        Intent i=new Intent(this, ActivityPrimos.class);
        startActivity(i);
    }

    //este método abre la activity "acerca_de"
    public void acercaDe(View view){
        Intent i=new Intent(this, ActivityAcercaDe.class);
        startActivity(i);
    }

    //este método abre la activity "zona_privada" si se pone la contraseña correcta
    public void zonaPrivada(View view){
        String usuario=etUser.getText().toString();
        String contraseña=etPw.getText().toString();
        if(usuario.equals("")!=true && contraseña.equals("")!=true && usuario.trim().equals(contraseña.trim())){
            Intent i=new Intent(this, ActivityZonaPrivada.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Esa no es la contraseña", Toast.LENGTH_SHORT).show();
        }

    }

    //este método sale de la aplicación mostrando un aviso
    public void salir(View view){
        new AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Desea realmente salir de la aplicación?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}