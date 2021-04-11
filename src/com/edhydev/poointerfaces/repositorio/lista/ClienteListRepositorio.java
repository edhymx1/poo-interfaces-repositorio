package com.edhydev.poointerfaces.repositorio.lista;

import com.edhydev.poointerfaces.modelo.Cliente;
import com.edhydev.poointerfaces.repositorio.AbstractaListRepositorio;
import com.edhydev.poointerfaces.repositorio.Direccion;
import com.edhydev.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC) {
                resultado = this.ordenar(campo, a,b);
            }
            else if(dir == Direccion.DESC){
                resultado = this.ordenar(campo,b,a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id":
                resultado = a.getId().compareTo(b.getId());
                break;
            case "nombre":
                resultado = a.getNombre().compareTo(b.getNombre());
                break;
            case "apellido":
                resultado = a.getApellido().compareTo(b.getApellido());
                break;
        }
        return resultado;
    }
}
