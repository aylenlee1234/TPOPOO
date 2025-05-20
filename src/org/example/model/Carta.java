package org.example.model;

public class Carta {
    private int id;
    private boolean visible;
    private boolean emparejada;

    public Carta(int id) {
        this.id = id;
        this.visible = false;
        this.emparejada = false;
    }

    public void voltear() {
        visible = !visible;
    }

    public boolean coincideCon(Carta otra) {
        return this.id == otra.id;
    }

    // Getters y setters
    public boolean isEmparejada() {
        return emparejada;
    }

    public void setEmparejada(boolean emparejada) {
        this.emparejada = emparejada;
    }

    public boolean isVisible() {
        return visible;
    }

    public int getId() {
        return id;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        if (emparejada) return "✓";
        if (visible) return String.valueOf(id);
        return "?";
    }

}
