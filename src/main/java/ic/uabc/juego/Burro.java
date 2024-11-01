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
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Burro {

    private Baraja baraja = new Baraja();
    protected List<Jugador> jugadores = new ArrayList();
    private int contadorRondas = 1;
    private int llaveCantorBurro = 0;
    protected ArrayList<Carta> cartasDeIntercambio = new ArrayList();
    private ArrayList<String> pilaDeManos;
    private String jugadorCadena;

    public Burro() {
    }

    protected void preparaJugadores(String nombre) {
        this.jugadores.add(new Jugador(nombre));
    }

    protected void preparaBaraja() {
        this.baraja.vaciarBaraja();
        this.baraja.creaBaraja(this.jugadores.size());
        this.baraja.mezclarBaraja();
    }

    protected void reparteBaraja() {
        Iterator var1 = this.jugadores.iterator();

        while (var1.hasNext()) {
            Jugador jugador = (Jugador) var1.next();
            jugador.setMano(this.baraja.tomarCartas());
        }

    }

    protected boolean encuentraGanador() {
        boolean cadenaCompleta = false;
        int posPerdedor = -1;

        for (int i = 0; i < this.jugadores.size(); ++i) {
            if (((Jugador) this.jugadores.get(i)).burroEstaCompleto()) {
                cadenaCompleta = true;
                posPerdedor = i;
                break;
            }
        }

        if (cadenaCompleta) {
            this.jugadores.remove(posPerdedor);
            if (this.jugadores.size() == 1) {
                return true;
            }
        }

        return false;
    }

    protected void ronda() {
        this.preparaBaraja();
        this.reparteBaraja();
    }

    protected int encuentraJugador(String nombre) {
        int posicion = 0;

        for (int i = 0; i < this.jugadores.size(); ++i) {
            if (((Jugador) this.jugadores.get(i)).getNombre().equals(nombre)) {
                posicion = i;
            }
        }

        return posicion;
    }

    protected ArrayList<String> obtenerPilaDeManos(int cantidadJugadores, boolean[] jugadorCantor) {
        ArrayList<String> posibleGanador = new ArrayList();

        for (int i = 0; i < cantidadJugadores; ++i) {
            if (jugadorCantor[i]) {
                posibleGanador.add(((Jugador) this.jugadores.get(i)).getNombre());
            }
        }

        Collections.shuffle(posibleGanador);
        String primerLugar = (String) posibleGanador.get(0);
        ArrayList<String> ordenDeManos = new ArrayList();
        Iterator var6 = this.jugadores.iterator();

        while (var6.hasNext()) {
            Jugador jugador = (Jugador) var6.next();
            if (!jugador.getNombre().equals(primerLugar)) {
                ordenDeManos.add(jugador.getNombre());
            }
        }

        Collections.shuffle(ordenDeManos);
        ordenDeManos.add(0, primerLugar);
        return ordenDeManos;
    }

    protected void cartasACambiar(int numeroCarta, int jugador) {
        this.cartasDeIntercambio.add(((Jugador) this.jugadores.get(jugador)).entregaCarta(numeroCarta - 1));
    }

    protected void cambioCartas() {
        Collections.rotate(this.cartasDeIntercambio, -1);
        this.jugadores.forEach((jugador) -> {
            jugador.agregarCarta((Carta) this.cartasDeIntercambio.get(0));
            this.cartasDeIntercambio.remove(0);
        });
    }

    protected int verificarGrito(int jugadorCanto) {
        int cantidadJugadores = this.jugadores.size();
        boolean[] jugadorCantor = new boolean[this.jugadores.size()];
        Arrays.fill(jugadorCantor, false);
        jugadorCantor[jugadorCanto] = true;
        this.pilaDeManos = this.obtenerPilaDeManos(cantidadJugadores, jugadorCantor);
        int primerLugar = this.encuentraJugador((String) this.pilaDeManos.get(0));
        int ultimoLugar = this.encuentraJugador((String) this.pilaDeManos.get(this.pilaDeManos.size() - 1));
        if (((Jugador) this.jugadores.get(primerLugar)).manoEsDelMismoValor()) {
            ((Jugador) this.jugadores.get(ultimoLugar)).agregaLetraABurro();
            this.jugadorCadena = (String) this.pilaDeManos.get(this.pilaDeManos.size() - 1);
            return ultimoLugar;
        } else {
            ((Jugador) this.jugadores.get(primerLugar)).agregaLetraABurro();
            this.jugadorCadena = (String) this.pilaDeManos.get(0);
            return primerLugar;
        }
    }

    public ArrayList<String> getPilaDeManos() {
        return this.pilaDeManos;
    }

    public void setPilaDeManos(ArrayList<String> pilaDeManos) {
        this.pilaDeManos = pilaDeManos;
    }

    public String getJugadorCadena() {
        return this.jugadorCadena;
    }

    public void setJugadorCadena(String jugadorCadena) {
        this.jugadorCadena = jugadorCadena;
    }
}
