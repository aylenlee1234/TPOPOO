package org.example;

import org.example.controller.JuegoController;
import org.example.model.Juego;
import org.example.model.Jugador;

public class App {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.agregarJugador(new Jugador("Player 1"));
        juego.agregarJugador(new Jugador("Player 2"));

        JuegoController controller = new JuegoController(juego);
        controller.iniciar();
    }
}
