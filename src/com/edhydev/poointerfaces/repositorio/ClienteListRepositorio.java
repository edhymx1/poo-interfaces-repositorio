package com.edhydev.poointerfaces.repositorio;

import com.edhydev.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdPagCrudRepositorio {

    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado =  null;
        for(Cliente cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
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

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
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
