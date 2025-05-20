package org.example.model;
import java.util.List;
import java.util.Collections;

public class Jugador {
    private String nombre;
    private int puntos;
    private int fallosConsecutivos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.fallosConsecutivos = 0;
    }

    public boolean jugarTurno(Tablero tablero) {
        int[] posiciones = elegirDosCartas(tablero);
        if (posiciones == null) return false;

        System.out.println(nombre + " elige: " + posiciones[0] + " y " + posiciones[1]);

        Carta carta1 = tablero.voltearCarta(posiciones[0]);
        Carta carta2 = tablero.voltearCarta(posiciones[1]);

        boolean acierto = false;
        if (carta1 != null && carta2 != null && carta1.coincideCon(carta2)) {
            carta1.setEmparejada(true);
            carta2.setEmparejada(true);
            puntos++;
            fallosConsecutivos = 0;
            System.out.println("¡Adivinó!");
            acierto = true;
        } else {
            fallosConsecutivos++;
            System.out.println("Falló.");
        }

        return acierto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getFallosConsecutivos() {
        return fallosConsecutivos;
    }

    public void reiniciarFallos() {
        fallosConsecutivos = 0;
    }

    public int[] elegirDosCartas(Tablero tablero) {
        List<Integer> posiciones = tablero.obtenerPosicionesDisponibles();
        if (posiciones.size() < 2) return null;

        Collections.shuffle(posiciones);
        return new int[]{posiciones.get(0), posiciones.get(1)};
    }

    public void sumarPunto() {
        puntos++;
    }

    public void incrementarFallos() {
        fallosConsecutivos++;
    }


}
