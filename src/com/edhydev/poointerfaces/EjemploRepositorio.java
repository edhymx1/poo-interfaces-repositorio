package com.edhydev.poointerfaces;

import com.edhydev.poointerfaces.modelo.Cliente;
import com.edhydev.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        OrdPagCrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Edgar", "Jiménez"));
        repo.crear(new Cliente("Daira", "Fornais"));
        repo.crear(new Cliente("Xavi", "Metallica"));
        repo.crear(new Cliente("Alfredo", "Fornais"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("========== Paginable ==========");

        List<Cliente> paginable = repo.listar(1,3);
        paginable.forEach(System.out::println);

        System.out.println("========== Ordenable ==========");
        List<Cliente> ordenable = repo.listar("nombre", Direccion.DESC);
        ordenable.forEach(System.out::println);

        System.out.println("========== Editar ==========");
        Cliente daiActualizar = new Cliente("Daira", "Ortiz");
        daiActualizar.setId(2);
        repo.editar(daiActualizar);
        Cliente dai = repo.porId(2);
        System.out.println(dai);
        System.out.println("=================");
        repo.listar("nombre", Direccion.ASC)
                .forEach(System.out::println);

        System.out.println("========== Eliminar ==========");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("========== Total ==========");
        System.out.println(repo.total());
    }
}
