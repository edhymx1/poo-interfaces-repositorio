package com.edhydev.poointerfaces;

import com.edhydev.poointerfaces.modelo.Producto;
import com.edhydev.poointerfaces.repositorio.Direccion;
import com.edhydev.poointerfaces.repositorio.OrdPagCrudRepositorio;
import com.edhydev.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        OrdPagCrudRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("mesa", 320.5));
        repo.crear(new Producto("silla", 150.99));
        repo.crear(new Producto("lampara", 300.18));
        repo.crear(new Producto("laptop", 16599.99));

        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);

        System.out.println("========== Paginable ==========");

        List<Producto> paginable = repo.listar(1,3);
        paginable.forEach(System.out::println);

        System.out.println("========== Ordenable ==========");
        List<Producto> ordenable = repo.listar("descripcion", Direccion.ASC);
        ordenable.forEach(System.out::println);

        System.out.println("========== Editar ==========");
        Producto lamparaActualizar = new Producto("lampara", 299.99);
        lamparaActualizar.setId(2);
        repo.editar(lamparaActualizar);
        Producto lampara = repo.porId(2);
        System.out.println(lampara);
        System.out.println("=================");
        repo.listar("precio", Direccion.ASC)
                .forEach(System.out::println);

        System.out.println("========== Eliminar ==========");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("========== Total ==========");
        System.out.println(repo.total());
    }
}
