package com.edhydev.poointerfaces.repositorio.lista;

import com.edhydev.poointerfaces.modelo.Cliente;
import com.edhydev.poointerfaces.modelo.Producto;
import com.edhydev.poointerfaces.repositorio.AbstractaListRepositorio;
import com.edhydev.poointerfaces.repositorio.Direccion;
import com.edhydev.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC) {
                resultado = this.ordenar(campo, a, b);
            }
            else if(dir == Direccion.DESC){
                resultado = this.ordenar(campo,b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id":
                resultado = a.getId().compareTo(b.getId());
                break;
            case "descripcion":
                resultado = a.getDescripcion().compareTo(b.getDescripcion());
                break;
            case "precio":
                resultado = a.getPrecio().compareTo(b.getPrecio());
                break;
        }
        return resultado;
    }
}
