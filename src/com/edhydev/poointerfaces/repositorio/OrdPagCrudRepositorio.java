package com.edhydev.poointerfaces.repositorio;

public interface OrdPagCrudRepositorio<T> extends OrdenableRepositorio<T>,
        PaginableRepositorio<T>,
        CrudRepositorio<T>,
        ContableRepositorio {
}
