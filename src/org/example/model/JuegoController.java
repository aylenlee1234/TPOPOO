package org.example.model;

public class JuegoController {
    private final Juego juego;

    public JuegoController(Juego juego) {
        this.juego = juego;
    }

    public void iniciar() {
        juego.iniciarJuego();

        while (!juego.termino()) {
            juego.jugarTurno();               // Se juegan las cartas (y se marcan visibles)
            juego.getTablero().mostrar();       // 👀 Mostrás las cartas con sus valores

            // Esperás un poco para que el jugador vea el resultado
            try {
                Thread.sleep(1000); // 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            juego.getTablero().ocultarNoEmparejadas();  // Luego se ocultan
            juego.siguienteTurno();

        }

        juego.finalizarJuego();
    }
}
