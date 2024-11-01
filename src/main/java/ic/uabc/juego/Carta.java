/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uabc.juego;

/**
 *
 * @author VOM
 */

public class Carta {
    private int valor;
    private String palo;

    public Carta() {
        this.valor = 0;
        this.palo = this.palo = "";
    }

    public Carta(String palo, int valor) {
        this.valor = valor;
        this.palo = palo;
    }

    public Carta(Carta carta) {
        this.valor = carta.valor;
        this.palo = carta.palo;
    }

    public String getPalo() {
        return this.palo;
    }

    public int getValor() {
        return this.valor;
    }

    /*@Override
    public String toString() {
        new String();
        String cadena = "[" + this.valor;
        cadena = cadena + " " + this.palo + "]";
        return cadena;
    }*/
    /**
     * Metodo ToSting de case Carta
     * @return String de carta
     */
    @Override
    public String toString(){
        String cadena= new String();
        cadena= "["+valor;
        cadena+=" "+palo+"]";
        return cadena;
    }
}