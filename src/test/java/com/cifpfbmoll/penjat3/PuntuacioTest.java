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

    private Puntuacio puntuacio;

    @BeforeEach
    public void reinici(){
        puntuacio=new Puntuacio();
    }


    @Test
    public void testGetParaulaSecretaDificultat1(){
        puntuacio.getParaulaSecretaDificultat(1);
        assertEquals(5,puntuacio.getIntents());
    }

    @Test
    public void testGetParaulaSecretaDificultat2() {
        puntuacio.getParaulaSecretaDificultat(2);
        assertEquals(4,puntuacio.getIntents());
    }

    @Test
    public void testGetParaulaSecretaDificultat3() {
        puntuacio.getParaulaSecretaDificultat(7);
        assertEquals(0,puntuacio.getIntents());
    }

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

    @Test
    public void testCalcularPuntuacio1() {
        String[] palabraEdivinada = {null,"a","r","a","u","l","a"};
        puntuacio.getParaulaSecretaDificultat(1);
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEdivinada,3);
        assertEquals(60,puntuacioReal);
    }
    

    @Test
    public void testCalcularPuntuacio2() {
        String[] palabraEdivinada = {null,null,"r",null,"u","l",null};
        puntuacio.getParaulaSecretaDificultat(3);
        float puntuacioReal = puntuacio.calcularPuntuacio(palabraEdivinada,3);
        assertEquals(90,puntuacioReal);
    }
//nvl 1=200, 2=400, 3=600 si no hi ha paraula bonus, si hi ha +100
    @Test
    public void testCalcularPuntuacio3() {
        String paraula=puntuacio.getParaulaSecretaDificultat(1);
        String [] palabraEndevinada = new String[paraula.length()];
        for (int n = 0; n < paraula.length(); n++) {
                palabraEndevinada[n] =String.valueOf(paraula.charAt(n)) ;
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
}