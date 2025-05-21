package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {
    private List<Carta> cartas;

    public Tablero() {
        cartas = new ArrayList<>();
    }

    public void mezclarCartas(int cantidadPares) {
        for (int i = 0; i < cantidadPares; i++) {
            cartas.add(new Carta(i));
            cartas.add(new Carta(i));
        }
        Collections.shuffle(cartas);
    }

    public Carta revelarCarta(int posicion) {
        if (posicion >= 0 && posicion < cartas.size()) {
            Carta carta = cartas.get(posicion);
            if (!carta.isEmparejada()) {
                carta.voltear();
                return carta;
            }
        }
        System.out.println("Posicion invalida o carta ya emparejada.");
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

    public boolean compararCartas(int pos1, int pos2) {
        if (pos1 >= 0 && pos1 < cartas.size() && pos2 >= 0 && pos2 < cartas.size()) {
            Carta c1 = cartas.get(pos1);
            Carta c2 = cartas.get(pos2);
            return c1.coincideCon(c2);
        }
        return false;
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
