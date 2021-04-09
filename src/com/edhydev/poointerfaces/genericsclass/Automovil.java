package com.edhydev.poointerfaces.genericsclass;

public class Automovil {
    private String marca;

    public Automovil(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "marca='" + marca + '\'' +
                '}';
    }
}
