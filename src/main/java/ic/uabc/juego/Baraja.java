/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uabc.juego;

/**
 *
 * @author VOM
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Baraja {
    private List<Carta> baraja = new ArrayList();
    private String[] palo = new String[]{"Oros", "Copas", "Espadas", "Bastos"};
    private int numeroJugadores;

    public Baraja() {
    }

    public void creaBaraja(int numeroJugadores) {
        String[] var2 = this.palo;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String p = var2[var4];
            IntStream.rangeClosed(1, numeroJugadores).forEach((j) -> {
                this.baraja.add(new Carta(p, j));
            });
        }

    }

    public void vaciarBaraja() {
        this.baraja.clear();
    }

    public void mezclarBaraja() {
        Collections.shuffle(this.baraja);
    }

    public Carta entregaCarta() {
        return (Carta)this.baraja.remove(0);
    }

    public List<Carta> tomarCartas() {
        List<Carta> mano = new ArrayList();
        IntStream.range(0, 4).forEach((i) -> {
            mano.add(this.entregaCarta());
        });
        return mano;
    }

    public int getNumeroJugadores() {
        return this.numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }
}