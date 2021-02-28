package com.cifpfbmoll.penjat3;

import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @author Jaume
 */
public class Puntuacio {
    /**
     * String on es guardara el valor de la paraula a endevina.
     */
    private String paraula = "";
    /**
     * int on es guardara el nivell de dificultat triat per el jugador.
     */
    private int dificultat = 0;
    /**
     * int on es guardaran el nombre de intents que tendra el jugador per endevinar
     * la paraula secreta. Aquest nombre d'intents s'assignara depenguent a la 
     * dificultat triada.
     */
    private int intents = 0;
    /**
     * long on es guardara un numero que indicara en quin moment ha comensat la partida.
     */
    private long inici;
    /**
     * long on es guardara el temps total que ha necesitat el jugador per acabar la ronda.
     */
    private float temps;
    /**
     * Array de Strings d'on es cuira una String per guardar-la en l'atribut paraula si la
     * dificultat triada ha estat 1.
     * 
     */
    private final String[] paraules1 = {"cargol","porc","aranya","patates","farina","nabiu","elefant"};
    /**
     * Array de Strings d'on es cuira una String per guardar-la en l'atribut paraula si la
     * dificultat triada ha estat 2.
     * 
     */
    private final String[] paraules2 = {"periquito", "peix espasa","nectarina", "peix daurat","xinxilla","armadillo","llenties"};
    /**
     * Array de Strings d'on es cuira una String per guardar-la en l'atribut paraula si la
     * dificultat triada ha estat 3.
     * 
     */
    private final String[] paraules3 = {"escombraries","escopinyes","engronxador","desnonament","malhauradament","malbaratament",};
    /**
     * Array de Strings que servira per comprobar si la paraula endivinada conte
     * alguna d'aquestes lletres.
     * 
     */
    private final String[] letresBonus = {"x", "h", "y"};

    public int getIntents() {
        return intents;
    }

    public float getTemps() {
        return temps;
    }
    /**
     * Metode que serveix per crear la Sring a endevinar, l'int de nombre de intents 
     * que tendra el jugador per aconseguir-ho i el long per saber quan ha començat la partida. 
     * Aquest metode rep un int per parametre el qual utilitzara per asignar una valor o un altre
     * al int intents i a la String paraula. Despres assignara el temps actual al float inici i
     * retornara la String paraula.
     * 
     * @param dificultat int que fa referenci al nivell de dificultat triat per el jugador.
     * @return paraula String que sera la paraula a endevinar.
     */
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
    /**
     * Metode que calcula la puntuacio obtinguda per el jugador a n'aquesta ronda.
     * Rep per paramete una Array de Strings on esta guardada la paraula endevinada
     * per el jugador(pot no estar completa) y l'int vides(encara que no s'emplea
     * en tot el metode). Per començar es crearan unes variables: puntuacio, percentatge,
     * fi(om es guardara el temps actual) y temps que sera el resultat de resta inici(atribut)
     * y la variable fi, donant com a resultat el temps que ha durat la ronda. Despres 
     * es canvien els valors null de la Array palabra Endevinada per ""(res) y es guarda 
     * dins una String anomenada str. Si la String str coincideix totalment amb la String
     * paraula de la instancia s'assignara valor=1000 a la variable puntuacio y despres s'assignara
     * un valors a la variable percentatge depenguent del valor de la vartiable dificultat de la instancia 
     * i de si la String str conte una de les lletres de la Array letresBonus. Despues s'actualitza el valor
     * de la puntuacio multiplicant puntuaciop per percentatge i es suma a n'aquesta puntuacio un valor que 
     * depen del temps utilitzat per resoldre la paraula.Si la String str no coincideix totalment amb la String
     * paraula de la instancia la puntuacio es calculara multiplicant per 10 la variable dificultat de la instancia
     * y despres multiplicant el resultat per la llargaria de la String str. Retornara la puntuacio.
     * 
     * @param palabraEdivinada Array de Strings en la cual es troba la paraula
     * endevinada per el jugador seperada en lletres.
     * @param vides int en el qual es troben el numero d'intents que li quedaven al jugador.
     * @return puntuacio float que fa referencia a la puntuacio obtinguada per el juador.
     */
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
    /**
     * Metode que retorna una bolea true si las String inputStr conte una de las lletres
     * de l'Array de Strings items. En cas contrari retorna false. 
     * 
     * @param inputStr String es la paraula endevinada per el jugador.
     * @param items Array de strings on estan guardades unes paraules
     * @return un bolea.
     */
    private boolean stringContainsItemFromList(String inputStr, String[] items) {
        return Arrays.stream(items).anyMatch(inputStr::contains);
    }


}
