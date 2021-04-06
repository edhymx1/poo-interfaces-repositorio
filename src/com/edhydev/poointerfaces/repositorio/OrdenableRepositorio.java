package com.edhydev.poointerfaces.repositorio;

import com.edhydev.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {

    List<Cliente> listar(String campo, Direccion dir);

}
