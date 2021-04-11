package com.edhydev.poointerfaces;

import com.edhydev.poointerfaces.modelo.Cliente;
import com.edhydev.poointerfaces.repositorio.*;
import com.edhydev.poointerfaces.repositorio.excepciones.AccesoDatoException;
import com.edhydev.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import com.edhydev.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import com.edhydev.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import com.edhydev.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {

    public static void main(String[] args) {
        try {
            OrdPagCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Edgar", "Jiménez"));
            repo.crear(new Cliente("Daira", "Fornais"));
            repo.crear(new Cliente("Xavi", "Metallica"));
            repo.crear(new Cliente("Alfredo", "Fornais"));
            
            Cliente andres = new Cliente("Andrés", "Guzmán");
            repo.crear(andres);
            repo.crear(andres);
            
            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);

            System.out.println("========== Paginable ==========");

            List<Cliente> paginable = repo.listar(1, 3);
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
            repo.eliminar(60);
            repo.listar().forEach(System.out::println);

            System.out.println("========== Total ==========");
            System.out.println(repo.total());
        } catch(RegistroDuplicadoAccesoDatoException e) {
            System.out.println("RegistroDuplicado: " + e.getMessage());
            e.printStackTrace();
        } catch (LecturaAccesoDatoException e) {
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        } catch(EscrituraAccesoDatoException e) {
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        } catch(AccesoDatoException e) {
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
