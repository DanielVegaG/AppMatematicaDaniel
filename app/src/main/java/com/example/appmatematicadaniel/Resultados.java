package com.example.appmatematicadaniel;

import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultados {
    //arrayLists para meter los datos de las activities "num_ranom", "primos" y "par_impar"
    private static ArrayList<String> resRandom = new ArrayList<String>();
    private static ArrayList<String> resPrimos = new ArrayList<String>();
    private static ArrayList<String> resParImpar = new ArrayList<String>();

    /**
     * Este método muestra en el TextView resultados
     * los últimos 5 números introducidos en la activity "num_random"
     *
     * @param n1,    primer número
     * @param n2,    número final
     * @param res,   número aleatorio generado
     * @param tvRes, TextView resultado, lo que se muestra por pantalla en la activity en la que se llama
     */
    public static void resultadosNRandom(int n1, int n2, int res, TextView tvRes) {
        String s="Se han introducido los números: " + n1 + " y " + n2 + ", y el número aleatorio generado es: " + res;

        resultados(s,resRandom,tvRes);

        Log.d("resultados", "Se ha pasado por el método \"resultadosNRandom\"");
    }

    /**
     * Este método muestra en el TextView resultados
     * los últimos 5 números introducidos en la activity "primos"
     *
     * @param n,     número que se quiere saber si es primo
     * @param primo, string que dice si es primo o no
     * @param tvRes, TextView resultado, lo que se muestra por pantalla en la activity en la que se llama
     */
    public static void resultadosPrimos(int n, String primo, TextView tvRes) {
        String s = "¿" + n + " es primo? " + primo + " es primo";

        resultados(s,resPrimos,tvRes);

        Log.d("resultados", "Se ha pasado por el método \"resultadosPrimos\"");
    }

    /**
     * Este método muestra en el TextView resultados
     * los últimos 5 números introducidos en la activity "par_impar"
     *
     * @param número,  número que se quiere saber si es par o impar
     * @param rbPar,   botón par
     * @param rbImpar, botón impar
     * @param tvRes,   TextView resultado, lo que se muestra por pantalla en la activity en la que se llama
     */
    public static void resultadosParImpar(int número, RadioButton rbPar, RadioButton rbImpar, TextView tvRes) {
        String s = "",sAux = "";
        if (número % 2 == 0 && rbPar.isChecked()) {
            sAux = "es par y, ¡has acertado!";
        } else if (número % 2 != 0 && rbImpar.isChecked()) {
            sAux = "es impar y, ¡has acertado!";
        } else if (número % 2 == 0 && !rbPar.isChecked()) {
            sAux = "es par y, ni has intentado acertar, era muy fácil";
        } else if (número % 2 != 0 && !rbImpar.isChecked()) {
            sAux = "es impar y, ni has intentado acertar, era muy fácil";
        }
        s=número+": "+sAux;

        resultados(s,resParImpar,tvRes);

        Log.d("resultados", "Se ha pasado por el método \"resultadosParImpar\"");
    }

    /**
     * Este es un método auxiliar para mostrar los resultados
     * Mete la cadena que se le pase en el array que se diga para que lo muestre el parámetro del TextView
     * @param s1, la cadena que se va a meter en el ArrayList
     * @param res, el ArrayList en el que se meten los datos
     * @param tv, el TextView en el que se muestran los datos
     */
    public static void resultados(String s1, ArrayList<String> res, TextView tv){
        String aux="";
        res.add(s1);

        //recorre el ArrayList y mete en "aux" los resultados para después mostrarlos
        for (int i = 0; i < res.size(); i++) {
            aux=res.get(i)+"\n"+aux;
        }
        tv.setText(aux);
    }
}
