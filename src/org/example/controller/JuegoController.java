package org.example.controller;

import org.example.model.Juego;

public class JuegoController {
    private Juego juego;

    public JuegoController(Juego juego) {
        this.juego = juego;
    }

    public void iniciar() {
        juego.iniciarJuego();

        while (!juego.termino()) {
            juego.jugarTurno();
            juego.siguienteTurno();
        }

        juego.finalizarJuego();
    }
}
