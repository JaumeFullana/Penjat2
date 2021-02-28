package com.cifpfbmoll.penjat3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaulerTest {
    /**
     * Objecte de la clase Tauler per se inicialitzat abans de cada clase.
     */
    private Tauler tauler;
    /**
     * Metode que inicialitza l'objecte tauler y despres crida el metode inicialitzarPartida 
     * damunt de la instancia d'aquest tauler. Pasa per parametre la String "paraula" i l'int 4.
     * Aquest metode es crida 1 vegada antes de provar cada test.
     */
    @BeforeEach
    void reiniciar(){
        this.tauler = new Tauler();
        this.tauler.inicialitzarPartida("paraula", 4);
    }
    /**
     * Metode test que comprova si l'atribut paraulaSecreta de l'objecte tauler es igual
     * a una Array de caracters concreta.
     */
    @Test
    void inicialitzarPartidaParaulaSecreta() {
        assertArrayEquals(new char[]{'p', 'a', 'r', 'a', 'u', 'l', 'a'}, this.tauler.getParaulaSecreta());
    }
    /**
     * Metode test que comprova si l'atribut intents de l'objecte tauler es igual a 4.
     */
    @Test
    void inicialitzarPartidaNombreIntents() {
        assertEquals(4, this.tauler.getIntents());
    }
    /**
     * Metode test que comprova si el metode verificar quan li pases una String "ll"
     * retorna "Lletra incorrecte".
     */
    @Test
    void verificarEntradaIncorrecte() {
        assertEquals("Lletra incorrecte",this.tauler.verificar("ll"));
    }
    /**
     * Metode test que primer crida al metode verificar pasant-li per parametre una "a"
     * i despres comprova si l'atribut palabraEndevinada del objecte tauler es igual
     * a una Array de Sting concreta.
     */
    @Test
    void verificarEntradaCorrecteEncertat() {
        this.tauler.verificar("a");
        assertArrayEquals(new String[]{ null,"a",null,"a",null,null,"a" },this.tauler.getPalabraEndevinada());
    }
    /**
     * Metode test que primer crida al metode verificar pasant-li per parametre una "n"
     * i despres comprova si l'atribut intents es igual a l'int 3.
     */
    @Test
    void verificarEntradaCorrecteErrada() {
        this.tauler.verificar("n");
        assertEquals(3,this.tauler.getIntents());
    }
    /**
     * Metode test que comprova si el que retorna el metode imprimir es igual
     * a una String concreta.
     */
    @Test
    void imprimirCapEncert() {
        assertEquals("_______", this.tauler.imprimir());
    }
    /**
     * Metode test que primer crida al metode verificar pasant-li una "a" per
     * parametere i despres comprova si el metode imprimir retorna una String
     * concreta.
     */
    @Test
    void imprimirAmbLletres() {
        this.tauler.verificar("a");
        assertEquals("_a_a__a", this.tauler.imprimir());
    }
    /**
     * Metode test que primer va cridant al metode verificar 5 vegades pasant-li 
     * una "a", una "p", una "r", una "u" i una "l" per parametere i despres 
     * comprova si el metode imprimir retorna una String en concret.
     */
    @Test
    void imprimirTotEncertat() {
        this.tauler.verificar("a");
        this.tauler.verificar("p");
        this.tauler.verificar("r");
        this.tauler.verificar("u");
        this.tauler.verificar("l");
        assertEquals("paraula", this.tauler.imprimir());
    }
    /**
     * Metode test que comprova si el metode imprimirVides retorna una String en concret.
     */
    @Test
    void imprimirVidesPlural() {
        assertEquals("Et queden 4 vides de 4", this.tauler.imprimirVides());
    }
    /**
     * Metode test que primer va cridant al metode verificar 3 vegades pasant-li 
     * una "n" 3 vegades per parametere i despres comprova si el metode imprimirVides 
     * retorna una String en concret.
     */
    @Test
    void imprimirVidesSingular() {
        this.tauler.verificar("n");
        this.tauler.verificar("n");
        this.tauler.verificar("n");
        assertEquals("Et queda 1 vida de 4", this.tauler.imprimirVides());
    }
    /**
     * Metode test que primer crida al metode verificar pasant-li una "n" per 
     * parametere i despres comprova si l'atribut intents de l'objecte tauler
     * te una valor igual a 3.
     */
    @Test
    void restarIntents() {
        this.tauler.verificar("n");
        assertEquals(3, this.tauler.getIntents());
    }
    /**
     * Metode test que primer va cridant al metode verificar 5 vegades pasant-li 
     * una "a", una "p", una "r", una "u" i una "l" per parametere i despres 
     * comprova si el metode hasGuanyat retorna un boolea true.
     */
    @Test
    void hasGuanyatTrue() {
        this.tauler.verificar("a");
        this.tauler.verificar("p");
        this.tauler.verificar("r");
        this.tauler.verificar("u");
        this.tauler.verificar("l");
        assertTrue(this.tauler.hasGuanyat());
    }
    /**
     * Metode test que comprova si el metode hasGuanyat retorna un boolea false.
     */
    @Test
    void hasGuanyatFalse() {
        assertFalse(this.tauler.hasGuanyat());
    }
}