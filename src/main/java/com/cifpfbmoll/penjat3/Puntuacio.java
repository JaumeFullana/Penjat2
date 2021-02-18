package com.cifpfbmoll.penjat3;

import java.util.Arrays;
import java.util.Random;

public class Puntuacio {

    private String paraula = "";
    private int dificultat = 0;
    private int intents = 0;
    private long inici;
    private float temps;
    private final String[] paraules1 = {"cargol","porc","aranya","patates","farina","nabiu","elefant"};
    private final String[] paraules2 = {"periquito", "peix espasa","nectarina", "peix daurat","xinxilla","armadillo","llenties"};
    private final String[] paraules3 = {"escombraries","escopinyes","engronxador","desnonament","malhauradament","malbaratament",};
    private final String[] letresBonus = {"x", "h", "y"};

    public int getIntents() {
        return intents;
    }

    public float getTemps() {
        return temps;
    }

    public String getParaulaSecretaDificultat(int dificultat){
        paraula = "err";
        this.dificultat = dificultat;
        if(dificultat == 1){
            int rnd = new Random().nextInt(paraules1.length);
            paraula = paraules1[rnd];
            this.intents = 5;
        }else if(dificultat == 2){
            int rnd = new Random().nextInt(paraules2.length);
            paraula = paraules2[rnd];
            this.intents = 4;
        }else if(dificultat == 3){
            int rnd = new Random().nextInt(paraules3.length);
            paraula = paraules3[rnd];
            this.intents = 3;
        }
        inici = System.currentTimeMillis();
        return paraula;
    }

    public float calcularPuntuacio(String[] palabraEdivinada, int vides){
        float puntuacio = 0;
        float percentatge = 0f;
        long fi = System.currentTimeMillis();
        temps = (float) ((fi - inici)/1000);//calcul de tempps, inici s'instancia a l'anterior metode

        for (int i=0; i < palabraEdivinada.length; i++) {
            if(palabraEdivinada[i] == null) palabraEdivinada[i] = "";//canvia null en la array per ""
        }
        String str = String.join("", palabraEdivinada);//pasa l'array a una string
        if(str.equals(this.paraula)){//si la paraula ha estat endevinada
            puntuacio = 1000;
            switch(this.dificultat) {//suma de percentatge segons la dificultad
                case 1:
                    percentatge = percentatge + 0.1f;
                    break;
                case 2:
                    percentatge = percentatge + 0.2f;
                    break;
                case 3:
                    percentatge = percentatge + 0.3f;
                    break;
                default:
            }
            if(stringContainsItemFromList(str,letresBonus)){//si la str(string de paraula endevinada) conte cap lletra bonus
                percentatge = percentatge + 0.01f;
            }
            if(percentatge > 0){//sempre es fa si la paraula ha estat endivinada
                puntuacio = puntuacio * percentatge;
            }

            int puntXTemps = ((100 * this.dificultat) - (int)Math.round(temps));//punts que dona segons temps utilitzat
            if(puntuacio > 0 || puntXTemps > 0){//es suma el punts de temps als punts totals
                puntuacio = puntuacio + puntXTemps;
            }

        }else{
            puntuacio = (10 * this.dificultat) * str.length();//calcul de puntuacio si la paraula no ha estat endevinada
        }

        return puntuacio;
    }

    private boolean stringContainsItemFromList(String inputStr, String[] items) {
        return Arrays.stream(items).anyMatch(inputStr::contains);
    }


}
