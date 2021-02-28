package com.cifpfbmoll.penjat3;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Util {

    /**
     * Metode que rep per parametre una String perque sigui impresa per pantalla
     * i despres rebre un input del jugador i guardarlo dins la variable valor.
     * Retorna la variable valor.
     * 
     * @param enunciat String amb la frase a imprimir per pantalla
     * @return valor l'input que escriu el jugador
     */
    public static String makeQuestion(String enunciat){
        String valor = " ";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
            System.out.print(enunciat+"  : ");
            valor = br.readLine();
        } catch (IOException ex) {
            System.out.println("Error");
        }
        return valor;
        }
    /**
     * Metode que rep per parametre una String y comprova si aquesta conte un 
     * valor numeric. Retorna true si es aixi o false si no.
     * 
     * @param cadena String a comprovar
     * @return boolea
     */
    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

}
