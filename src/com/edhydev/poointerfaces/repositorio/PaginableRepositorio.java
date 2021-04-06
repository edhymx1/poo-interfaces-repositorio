package com.edhydev.poointerfaces.repositorio;

import com.edhydev.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {

    List<Cliente> listar(int desde, int hasta);

}
