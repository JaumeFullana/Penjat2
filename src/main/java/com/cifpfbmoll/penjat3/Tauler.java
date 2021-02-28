package com.cifpfbmoll.penjat3;

public class Tauler {
    /**
     * Array de caracters on es guardara la paraula a endevinar seperada per caracters.
     */
    private char[] paraulaSecreta;
    /**
     * Array de Strings de llaragaria igual a la paraula a endevinar que un principi 
     * tendra tots els index null.
     */
    private String[] palabraEndevinada;
    /**
     * int que fa referencia al numero de intents que li queden al jugador en aquesta ronda.
     */
    private int intents;
    /**
     * int que fa referencia al numero de intents amb el que ha començat el jugador aquesta ronda.
     */
    private int totalIntents;

    public char[] getParaulaSecreta() {
        return paraulaSecreta;
    }

    public int getIntents() {
        return intents;
    }

    public int getTotalIntents() {
        return totalIntents;
    }

    public String[] getPalabraEndevinada() {
        return palabraEndevinada;
    }

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        this.palabraEndevinada = palabraEndevinada;
    }

    public void setIntents(int intents) {
        this.intents = intents;
    }

    public void setParaulaSecreta(char[] paraulaSecreta) {
        this.paraulaSecreta = paraulaSecreta;
    }

    public void setTotalIntents(int totalIntents) {
        this.totalIntents = totalIntents;
    }

    public Tauler() {
        paraulaSecreta = new char[0];
        palabraEndevinada = new String[0];
        intents = 0;
        totalIntents = 0;
    }
    /**
     * Metode que assigna valors a tots els atributs de la instancia. S'inicialitzen 
     * les Arrays paraulaSecreta i paraulaEndevinada de la instancia amb una longitud 
     * que es igual a la longitud de la String p. A cada index de l'Array paraulaSecreta 
     * es fica la lletra que es troba n'aquell index de la String p y a la palabraEndevinada
     * es deixa plena de nulls excepte si hi ha un espai en la String p, que es posa a n'el
     * mateix index. Als atributs intents i totalIntents se li assigna el valor de i.
     * 
     * @param p String que es la paraula a endevinar.
     * @param i int que son el nombre de intents que tendra el jugador a n'aquesta. 
     * ronda per endevinar la paraula.
     */
    public void inicialitzarPartida(String p, int i){
        paraulaSecreta = new char[p.length()];
        for (int n = 0; n < p.length(); n++) {
            paraulaSecreta[n] = p.charAt(n) ;
        }
        palabraEndevinada = new String[p.length()];
        for (int n = 0; n < p.length(); n++) {
            if(p.charAt(n) == new Character(' ')){
                palabraEndevinada[n] = " " ;
            }
        }
        intents = i;
        totalIntents = i;

    }
    /**
     * Metode que pasa a una String anomenada result tots el index de la array palabraEndevinada.
     * Si es null afegeix "_", si es un espai afegeix " " i si es un altre caracter el copia.
     * 
     * @return result String que es omplida amb el valors de l'atribut palabraEndevinada.
     */
    public String imprimir() {
        String result = "";
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i] == null) {
                result = result+"_";
            }else if(palabraEndevinada[i] == " "){
                result = result+" ";
            }else {
                result = result+palabraEndevinada[i];
            }
        }
        return result;
    }
    /**
     * Metode que rep una String per parametre y comprova si es nomes 1 caracter.
     * Si no ho es retorna "lletra incorrecte", si ho es comprova si esta en algun
     * index de la paraulaSecreta. Primer crea un boolea=false, despres si el caracter esta en algun 
     * index de la paraulaSecreta canvia l'index de la palabraEndevinada per aquest caracter 
     * i assigna valor true al boolea. Despres, si el boolea es false resta un intent a traves
     * d'un altre metode. retorna "".
     * 
     * @param letra String que teoricament ha de se nomes 1 caracter.
     * @return "" o "Lletra incorrecte".
     */
    public String verificar(String letra) {
        if(letra.length() > 1){
            return "Lletra incorrecte";
        }else{
            boolean exist = false;
            for (int i = 0; i < paraulaSecreta.length; i++) {
                if (paraulaSecreta[i] == letra.charAt(0)) {
                    exist = true;
                    palabraEndevinada[i] = letra;
                }
            }
            if(!exist){
                restarIntent();
            }
        }
        return"";
    }
    /**
     * Metode que assigna a la String message un text on s'indiquen les vides que li queden
     * al jugador. Retorna aquesta String.
     * 
     * @return message String on s'indiquen les vides que li queden al jugador.
     */
    public String imprimirVides(){
        String message = String.format("Et queden %s vides de %s",intents, totalIntents);
        if(intents == 1) message = String.format("Et queda %s vida de %s",intents, totalIntents);
        return message;
    }
    /**
     * Resta 1 intent al atribut intents de la instancia.
     */
    public void restarIntent() {
        this.intents--;
    }
    /**
     * Metode que comprova si queda algun null dins la Array palabraEndevinada.
     * Si en queda colcun retorna false, si no true.
     * 
     * @return un boolea que fa referenci a si el jugador ha guanyat(true) o no
     * (false).
     */
    public boolean hasGuanyat() {
        boolean valor = true;
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i] == null) {
                return false;
            }
        }
        return valor;
    }

}
