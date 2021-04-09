package com.edhydev.generics;

import com.edhydev.poointerfaces.modelo.Cliente;
import com.edhydev.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenerico {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Edgar", "Jiménez"));

        Cliente edgar = clientes.iterator().next();

        Cliente[] clientesArreglo = {
                new Cliente("Andres", "Guzmán"),
                new Cliente("Edgar", "Jiménez")
        };

        Integer[] enteros = {1, 2, 3};

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> enterosLista = fromArrayToList(enteros);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Luis", "Pepe", "Juam", "Julio"}, clientesArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiumList = fromArrayToList(new ClientePremium[]{
                new ClientePremium("Paco", "Fernandez")
        });

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiumList);

        System.out.println("Máximo de 1, 9 y 4 es: " + maximo(1,9,4));
        System.out.println("Máximo de 3.9, 11.6 y 7.78 es: " + maximo(3.9,11.6,7.78));
        System.out.println("Máximo de zanahoría, arándanos y manzana es: " + maximo("zanahoría", "arándanos", "manzana"));

    }

    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if(b.compareTo(max) > 0) {
            max = b;
        }

        if(c.compareTo(max) > 0) {
            max = c;
        }

        return max;
    }

}
