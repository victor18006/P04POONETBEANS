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
import java.util.Iterator;
import java.util.List;

public class Mano {
    private List<Carta> cartas = new ArrayList();

    public Mano() {
    }

    public void agregarCarta(Carta carta) {
        this.cartas.add(carta);
    }

    public Carta entregaCarta(int pos) {
        return (Carta)this.cartas.remove(pos);
    }

    public boolean esDelMismoValor() {
        return !this.cartas.isEmpty() && this.cartas.stream().allMatch((carta) -> {
            return carta.getValor() == ((Carta)this.cartas.get(0)).getValor();
        });
    }

    public String mostrarMano() {
        StringBuilder sb = new StringBuilder();
        Iterator var2 = this.cartas.iterator();

        while(var2.hasNext()) {
            Carta carta = (Carta)var2.next();
            sb.append(carta.toString()).append(" ");
        }

        return sb.toString();
    }

    public List<Carta> getCartas() {
        return this.cartas;
    }
}