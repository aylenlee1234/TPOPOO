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

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getFallosConsecutivos() {
        return fallosConsecutivos;
    }

    public void reiniciarRacha() {
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

    public void registrarFallo() {
        fallosConsecutivos++;
    }


}
