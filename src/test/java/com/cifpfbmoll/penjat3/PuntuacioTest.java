/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cifpfbmoll.penjat3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author jaume
 */
public class PuntuacioTest {
    /**
     * Objecte de la clase Puntuacio per se inicialitzat abans de cada test.
     */
    private Puntuacio puntuacio;
    /**
     * Metode que inicialitza la variable puntuacio. Aquest metode es crida 1 vegada
     * antes de provar cada test.
     */
    @BeforeEach
    public void reinici(){
        puntuacio=new Puntuacio();
    }

    /**
     * Metode parameterizedTest que corr el metode getParaulaSecretaDificultat damunt la instancia
     * puntuacio y comprova el nombre de intents. Se li pasen per parametre un valors int que se emplearan
     * com a dificultat que es pasa al metode getParaulaSecretaDificultat i com a intents, que sera el nombre
     * de intents que hauria de tenir l'usuari i que s'hauran guardad en l'atribut intents de la instancia puntuacio,
     * aixo es comprova a traves de l'assertEquals.
     */
    @ParameterizedTest
    @CsvSource({
        "1, 5",
        "2, 4",
        "7, 0"
    })
    public void testGetParaulaSecretaDificultat123(int dificultat, int intents){
        puntuacio.getParaulaSecretaDificultat(dificultat);
        assertEquals(intents,puntuacio.getIntents());
    }
    /**
     * Metode test que comprova si la funcio getParaulaSecretaDificultat retorna les
     * paraules correctes. Primer crea un bolea igual false, despues crea una String paraula que rep
     * el valor que retorna el metode getParaulaSecretaDificultat pasant-li per parametre
     * un 1. Despres crea una Array de Strings que teoricament ha de contenir la praula
     * que ha tornat la funcio getParaulaSecretaDificultat. Es comprova si es aixi, que
     * la paraula que ha retornat esta alla dedins, a traves de un for que si la trova canvia
     * el valor del boolea per true. Despres es comprova si el boolea es true.
     */
    @Test
    public void testGetParaulaSecretaDificultat4() {
        boolean trobat=false;
        String paraula=puntuacio.getParaulaSecretaDificultat(1);
        String[] paraules1 = {"cargol","porc","aranya","patates","farina","nabiu","elefant"};
        for (int i=0;i<paraules1.length;i++){
            if (paraules1[i].equals(paraula)){
                trobat=true;
            }
        }
        assertTrue(trobat);
    }
    /**
     * Metode test que comprova si la funcio getParaulaSecretaDificultat retorna les
     * paraules correctes. Primer crea un bolea igual false, despues crea una String paraula que rep
     * el valor que retorna el metode getParaulaSecretaDificultat pasant-li per parametre
     * un 3. Despres crea una Array de Strings que teoricament ha de contenir la praula
     * que ha tornat la funcio getParaulaSecretaDificultat. Es comprova si es aixi, que
     * la paraula que ha retornat esta alla dedins, a traves de un for que si la trova canvia
     * el valor del boolea per true. Despres es comprova si el boolea es true.
     */
    @Test
    public void testGetParaulaSecretaDificultat5() {
        boolean trobat=false;
        String paraula=puntuacio.getParaulaSecretaDificultat(3);
        String[] paraules3 = {"escombraries","escopinyes","engronxador","desnonament","malhauradament","malbaratament",};
        for (int i=0;i<paraules3.length;i++){
            if (paraules3[i].equals(paraula)){
                trobat=true;
            }
        }
        assertTrue(trobat);
    }
    /**
     * Metode test que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una Array de Strings on el primer index es null, 
     * crida al metode getParaulaSecretaDificultat pasant-li un 1 per parametre
     * i despres crea un float que rep el valor que retorna la funcio calcularPuntuacio,
     * que rep per parametre la Array de Strings i un int 3. Despres comprova si 
     * el float es igual a 60.
     */
    @Test
    public void testCalcularPuntuacio1() {
        String[] palabraEdivinada = {null,"a","r","a","u","l","a"};
        puntuacio.getParaulaSecretaDificultat(1);
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEdivinada,3);
        assertEquals(60,puntuacioReal);
    }
    /** 
     * Metode test que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una Array de Strings on on hi ha varis index null, 
     * crida al metode getParaulaSecretaDificultat pasant-li un 3 per parametre
     * i despres crea un float que rep el valor que retorna la funcio calcularPuntuacio,
     * que rep per parametre la Array de Strings i un int 3. Despres comprova si 
     * el float es igual a 90.
     */
    @Test
    public void testCalcularPuntuacio2() {
        String[] palabraEdivinada = {null,null,"r",null,"u","l",null};
        puntuacio.getParaulaSecretaDificultat(3);
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEdivinada,3);
        assertEquals(90,puntuacioReal);
    }
    /** 
     * Metode parametrizedTest que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una String paraula que rep el valor de la funcio getParaulaSecretaDificultat
     * pasantli per parametre un int dificultat. Crea una Array de Strings palabraEndevinada amb una
     * llaragaria igual a la String paraula creada antes, despres assigna a cada index de 
     * palabraEndevinada el caracter d'aquell mateix index en la String paraula, a traves de un for.
     * Despres es crea un int anomenat puntuacioEsperada que es igual a puntuacioAmbCaracter si la String paraula conte 
     * els caracters: "x", "y" o "h" o a puntuacioSenseCaracter si no conte cap d'aquests caracters. Despres es crea un 
     * float puntuacioReal que rep el valor que retorna la funcio calcularPuntuacio, que rep per 
     * parametre la Array de Strings palabraEndevinada i un int vides. Despres comprova si 
     * puntuacioEsperada es igual a puntuacioReal.
     */
    @ParameterizedTest
    @CsvSource({
        "1, 210, 200, 3",
        "2, 410, 400, 3",
        "3, 610, 600, 3"
    })
    public void testCalcularPuntuacio345(int dificultat, int puntuacioAmbCaracter, 
    int puntuacioSenseCaracter, int vides) {
        String paraula=puntuacio.getParaulaSecretaDificultat(dificultat);
        String [] palabraEndevinada = new String[paraula.length()];
        for (int n = 0; n < paraula.length(); n++) {
                palabraEndevinada[n]=String.valueOf(paraula.charAt(n)) ;
        }
        int puntuacioEsperada;
        if (paraula.contains("x") || paraula.contains("y") || paraula.contains("h")){
            puntuacioEsperada=puntuacioAmbCaracter;
        }
        else{
            puntuacioEsperada=puntuacioSenseCaracter;
        }
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEndevinada,vides);
        assertEquals(puntuacioEsperada,puntuacioReal);
    }
    /** 
     * Metode test que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una String paraula que rep el valor de la funcio getParaulaSecretaDificultat
     * pasantli per parametre un int dificultat. Crea una Array de Strings palabraEndevinada amb una
     * llaragaria igual a la String paraula creada antes, despres assigna a cada index de 
     * palabraEndevinada el caracter d'aquell mateix index en la String paraula, a traves de un for.
     * Despres es crea un int anomenat puntuacioEsperada que es igual a puntuacioAmbCaracter si la String paraula conte 
     * els caracters: "x", "y" o "h" o a puntuacioSenseCaracter si no conte cap d'aquests caracters. Despres es pausa
     * l'execucio del metode durant tempsPausa segons,una vegada passat el temps pausa es crea un float puntuacioReal 
     * que rep el valor que retorna la funcio calcularPuntuacio, que rep per parametre la Array de Strings 
     * palabraEndevinada i un int vides. Despres comprova si puntuacioEsperada es igual a puntuacioReal.
     */
    @ParameterizedTest
    @CsvSource({
        "3, 560, 550, 50000, 3",
        "2, 350, 340, 60000, 3"
    })
    public void testCalcularPuntuacio67(int dificultat, int puntuacioAmbCaracter, 
    int puntuacioSenseCaracter,int tempsPausa ,int vides) throws InterruptedException {
        String paraula=puntuacio.getParaulaSecretaDificultat(dificultat);
        String [] palabraEndevinada = new String[paraula.length()];
        for (int n = 0; n < paraula.length(); n++) {
                palabraEndevinada[n] =String.valueOf(paraula.charAt(n)) ;
        }
        int puntuacioEsperada;
        if (paraula.contains("x") || paraula.contains("y") || paraula.contains("h")){
            puntuacioEsperada=puntuacioAmbCaracter;
        }
        else{
            puntuacioEsperada=puntuacioSenseCaracter;
        }
        Thread.sleep(tempsPausa);
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEndevinada,vides);
        assertEquals(puntuacioEsperada,puntuacioReal);
    }
}