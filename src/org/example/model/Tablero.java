package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {
    private List<Carta> cartas;

    public Tablero() {
        cartas = new ArrayList<>();
    }

    public void inicializarCartas(int cantidadPares) {
        for (int i = 0; i < cantidadPares; i++) {
            cartas.add(new Carta(i));
            cartas.add(new Carta(i));
        }
        Collections.shuffle(cartas);
    }

    public Carta voltearCarta(int posicion) {
        if (posicion >= 0 && posicion < cartas.size()) {
            Carta carta = cartas.get(posicion);
            if (!carta.isEmparejada()) {
                carta.voltear();
                return carta;
            }
        }
        System.out.println("Posición inválida o carta ya emparejada.");
        return null;
    }

    public List<Integer> obtenerPosicionesDisponibles() {
        List<Integer> disponibles = new ArrayList<>();
        for (int i = 0; i < cartas.size(); i++) {
            if (!cartas.get(i).isEmparejada()) {
                disponibles.add(i);
            }
        }
        return disponibles;
    }

    public boolean quedanCartas() {
        for (Carta c : cartas) {
            if (!c.isEmparejada()) return true;
        }
        return false;
    }

    public void reordenar() {
        System.out.println("¡Se reordenan las cartas!");
        Collections.shuffle(cartas);
    }

    public void mostrar() {
        System.out.println("Tablero:");
        for (int i = 0; i < cartas.size(); i++) {
            Carta c = cartas.get(i);
            System.out.print("[" + c.toString() + "] ");
        }
        System.out.println();
    }

    public void ocultarNoEmparejadas() {
        for (Carta c : cartas) {
            if (!c.isEmparejada()) {
                c.setVisible(false);
            }
        }
    }


}
