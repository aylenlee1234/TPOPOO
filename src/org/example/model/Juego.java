package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private Tablero tablero;
    private int turnoActual;

    public Juego() {
        jugadores = new ArrayList<>();
        tablero = new Tablero();
        turnoActual = 0;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void iniciarJuego() {
        tablero.inicializarCartas(3); // 4 pares = 8 cartas
        System.out.println("¡Empieza el juego!");
    }

    public void iniciarTurno() {
        Jugador jugador = jugadores.get(turnoActual);
        tablero.mostrar(); // Mostrar antes de elegir

        int[] posiciones = jugador.elegirDosCartas(tablero);
        if (posiciones == null) return;

        int pos1 = posiciones[0];
        int pos2 = posiciones[1];

        Carta carta1 = tablero.voltearCarta(pos1);
        Carta carta2 = tablero.voltearCarta(pos2);

        System.out.println(jugador.getNombre() + " elige: " + pos1 + " y " + pos2);
        tablero.mostrar(); // Mostrar con cartas visibles

        // Pausa breve para ver las cartas
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean acierto = false;
        if (carta1 != null && carta2 != null && carta1.coincideCon(carta2)) {
            carta1.setEmparejada(true);
            carta2.setEmparejada(true);
            jugador.sumarPunto();
            jugador.reiniciarFallos();
            System.out.println("¡Adivinó!");
            acierto = true;
        } else {
            jugador.incrementarFallos();
            System.out.println("Falló.");
        }

        if (!acierto) {
            carta1.setVisible(false);
            carta2.setVisible(false);
        }

        if (jugador.getFallosConsecutivos() >= 3) {
            tablero.reordenar();
            jugador.reiniciarFallos();
        }
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.size();
    }

    public boolean termino() {
        return !tablero.quedanCartas();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void finalizarJuego() {
        System.out.println("Juego finalizado. Puntajes:");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getPuntos() + " puntos");
        }
    }
}
