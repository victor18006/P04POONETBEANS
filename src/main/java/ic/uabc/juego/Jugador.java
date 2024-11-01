/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uabc.juego;

/**
 *
 * @author VOM
 */

import java.util.List;
import java.util.Objects;

public class Jugador {
    private String nombre;
    private String burro;
    private Mano mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.burro = "";
        this.mano = new Mano();
    }

    public void setMano(List<Carta> cartas) {
        this.mano = new Mano();
        Mano var10001 = this.mano;
        Objects.requireNonNull(var10001);
        cartas.forEach(var10001::agregarCarta);
    }

    public Mano getMano() {
        return this.mano;
    }

    public String mostrarMano() {
        return this.mano.mostrarMano();
    }

    public void agregarCarta(Carta carta) {
        this.mano.agregarCarta(carta);
    }

    public Carta entregaCarta(int pos) {
        return this.mano.entregaCarta(pos);
    }

    public boolean manoEsDelMismoValor() {
        return this.mano.esDelMismoValor();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregaLetraABurro() {
        String var10001 = this.burro;
        this.burro = var10001 + "burro".charAt(this.burro.length());
    }

    public String getBurro() {
        return this.burro;
    }

    public boolean burroEstaCompleto() {
        return this.burro.equals("burro");
    }

    public int getCantidadDeLetrasEnCadena() {
        return this.burro.length();
    }
}