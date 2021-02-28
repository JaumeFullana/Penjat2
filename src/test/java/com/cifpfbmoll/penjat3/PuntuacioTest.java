/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cifpfbmoll.penjat3;

import org.junit.jupiter.api.Test;
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
     * Metode test que corr el metode getParaulaSecretaDificultat damunt la instancia
     * puntuacio, pasant per parametre un 1, i comprova si el intents que es guarden 
     * en la instancia es igual a 5.
     */
    @Test
    public void testGetParaulaSecretaDificultat1(){
        puntuacio.getParaulaSecretaDificultat(1);
        assertEquals(5,puntuacio.getIntents());
    }
    /**
     * Metode test que corr el metode getParaulaSecretaDificultat damunt la instancia
     * puntuacio, pasant per parametre un 2, i comprova si el intents que es guarden 
     * en la instancia es igual a 4.
     */
    @Test
    public void testGetParaulaSecretaDificultat2() {
        puntuacio.getParaulaSecretaDificultat(2);
        assertEquals(4,puntuacio.getIntents());
    }
    /**
     * Metode test que corr el metode getParaulaSecretaDificultat damunt la instancia
     * puntuacio, pasant per parametre un 7, i comprova si el intents que es guarden 
     * en la instancia es igual a 0.
     */
    @Test
    public void testGetParaulaSecretaDificultat3() {
        puntuacio.getParaulaSecretaDificultat(7);
        assertEquals(0,puntuacio.getIntents());
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
     * Metode test que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una String paraula que rep el valor de la funcio getParaulaSecretaDificultat
     * pasantli per parametre un int 1. Crea una Array de Strings palabraEndevinada amb una
     * llaragaria igual a la String paraula creada antes, despres assigna a cada index de 
     * palabraEndevinada el caracter d'aquell mateix index en la String paraula, a traves de un for.
     * Despres es crea un int anomenat puntuacioEsperada que es igual a 210 si la String paraula conte 
     * els caracters: "x", "y" o "h" o a 200 si no conte cap d'aquests caracters. Despres es crea un 
     * float puntuacioReal que rep el valor que retorna la funcio calcularPuntuacio, que rep per 
     * parametre la Array de Strings palabraEndevinada i un int 3. Despres comprova si 
     * puntuacioEsperada es igual a puntuacioReal.
     */
    @Test
    public void testCalcularPuntuacio3() {
        String paraula=puntuacio.getParaulaSecretaDificultat(1);
        String [] palabraEndevinada = new String[paraula.length()];
        for (int n = 0; n < paraula.length(); n++) {
                palabraEndevinada[n]=String.valueOf(paraula.charAt(n)) ;
        }
        int puntuacioEsperada;
        if (paraula.contains("x") || paraula.contains("y") || paraula.contains("h")){
            puntuacioEsperada=210;
        }
        else{
            puntuacioEsperada=200;
        }
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEndevinada,3);
        assertEquals(puntuacioEsperada,puntuacioReal);
    }
    /** 
     * Metode test que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una String paraula que rep el valor de la funcio getParaulaSecretaDificultat
     * pasantli per parametre un int 2. Crea una Array de Strings palabraEndevinada amb una
     * llaragaria igual a la String paraula creada antes, despres assigna a cada index de 
     * palabraEndevinada el caracter d'aquell mateix index en la String paraula, a traves de un for.
     * Despres es crea un int anomenat puntuacioEsperada que es igual a 410 si la String paraula conte 
     * els caracters: "x", "y" o "h" o a 400 si no conte cap d'aquests caracters. Despres es crea un 
     * float puntuacioReal que rep el valor que retorna la funcio calcularPuntuacio, que rep per 
     * parametre la Array de Strings palabraEndevinada i un int 3. Despres comprova si 
     * puntuacioEsperada es igual a puntuacioReal.
     */
    @Test
    public void testCalcularPuntuacio4() {
        String paraula=puntuacio.getParaulaSecretaDificultat(2);
        String [] palabraEndevinada = new String[paraula.length()];
        for (int n = 0; n < paraula.length(); n++) {
                palabraEndevinada[n] =String.valueOf(paraula.charAt(n)) ;
        }
        int puntuacioEsperada;
        if (paraula.contains("x") || paraula.contains("y") || paraula.contains("h")){
            puntuacioEsperada=410;
        }
        else{
            puntuacioEsperada=400;
        }
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEndevinada,3);
        assertEquals(puntuacioEsperada,puntuacioReal);
    }
    /** 
     * Metode test que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una String paraula que rep el valor de la funcio getParaulaSecretaDificultat
     * pasantli per parametre un int 3. Crea una Array de Strings palabraEndevinada amb una
     * llaragaria igual a la String paraula creada antes, despres assigna a cada index de 
     * palabraEndevinada el caracter d'aquell mateix index en la String paraula, a traves de un for.
     * Despres es crea un int anomenat puntuacioEsperada que es igual a 610 si la String paraula conte 
     * els caracters: "x", "y" o "h" o a 600 si no conte cap d'aquests caracters. Despres es crea un 
     * float puntuacioReal que rep el valor que retorna la funcio calcularPuntuacio, que rep per 
     * parametre la Array de Strings palabraEndevinada i un int 3. Despres comprova si 
     * puntuacioEsperada es igual a puntuacioReal.
     */
    @Test
    public void testCalcularPuntuacio5() {
        String paraula=puntuacio.getParaulaSecretaDificultat(3);
        String [] palabraEndevinada = new String[paraula.length()];
        for (int n = 0; n < paraula.length(); n++) {
                palabraEndevinada[n] =String.valueOf(paraula.charAt(n)) ;
        }
        int puntuacioEsperada;
        if (paraula.contains("x") || paraula.contains("y") || paraula.contains("h")){
            puntuacioEsperada=610;
        }
        else{
            puntuacioEsperada=600;
        }
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEndevinada,3);
        assertEquals(puntuacioEsperada,puntuacioReal);
    }
    /** 
     * Metode test que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una String paraula que rep el valor de la funcio getParaulaSecretaDificultat
     * pasantli per parametre un int 3. Crea una Array de Strings palabraEndevinada amb una
     * llaragaria igual a la String paraula creada antes, despres assigna a cada index de 
     * palabraEndevinada el caracter d'aquell mateix index en la String paraula, a traves de un for.
     * Despres es crea un int anomenat puntuacioEsperada que es igual a 560 si la String paraula conte 
     * els caracters: "x", "y" o "h" o a 550 si no conte cap d'aquests caracters. Despres es pausa
     * l'execucio del metode durant 50 segons,una vegada passats els 50 segons es crea un float puntuacioReal 
     * que rep el valor que retorna la funcio calcularPuntuacio, que rep per parametre la Array de Strings 
     * palabraEndevinada i un int 3. Despres comprova si puntuacioEsperada es igual a puntuacioReal.
     */
    @Test
    public void testCalcularPuntuacio6() throws InterruptedException {
        String paraula=puntuacio.getParaulaSecretaDificultat(3);
        String [] palabraEndevinada = new String[paraula.length()];
        for (int n = 0; n < paraula.length(); n++) {
                palabraEndevinada[n] =String.valueOf(paraula.charAt(n)) ;
        }
        int puntuacioEsperada;
        if (paraula.contains("x") || paraula.contains("y") || paraula.contains("h")){
            puntuacioEsperada=560;
        }
        else{
            puntuacioEsperada=550;
        }
        Thread.sleep(50000);
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEndevinada,3);
        assertEquals(puntuacioEsperada,puntuacioReal);
    }
    /** 
     * Metode test que prova quants de punts es consegueixen amb una praulaEndevinada concreta.
     * Primer crea una String paraula que rep el valor de la funcio getParaulaSecretaDificultat
     * pasantli per parametre un int 2. Crea una Array de Strings palabraEndevinada amb una
     * llaragaria igual a la String paraula creada antes, despres assigna a cada index de 
     * palabraEndevinada el caracter d'aquell mateix index en la String paraula, a traves de un for.
     * Despres es crea un int anomenat puntuacioEsperada que es igual a 350 si la String paraula conte 
     * els caracters: "x", "y" o "h" o a 540 si no conte cap d'aquests caracters. Despres es pausa
     * l'execucio del metode durant 60 segons,una vegada passats els 60 segons es crea un float puntuacioReal 
     * que rep el valor que retorna la funcio calcularPuntuacio, que rep per parametre la Array de Strings 
     * palabraEndevinada i un int 3. Despres comprova si puntuacioEsperada es igual a puntuacioReal.
     */
    @Test
    public void testCalcularPuntuacio7() throws InterruptedException {
        String paraula=puntuacio.getParaulaSecretaDificultat(2);
        String [] palabraEndevinada = new String[paraula.length()];
        for (int n = 0; n < paraula.length(); n++) {
                palabraEndevinada[n] =String.valueOf(paraula.charAt(n)) ;
        }
        int puntuacioEsperada;
        if (paraula.contains("x") || paraula.contains("y") || paraula.contains("h")){
            puntuacioEsperada=350;
        }
        else{
            puntuacioEsperada=340;
        }
        Thread.sleep(60000);
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEndevinada,3);
        assertEquals(puntuacioEsperada,puntuacioReal);
    }
}