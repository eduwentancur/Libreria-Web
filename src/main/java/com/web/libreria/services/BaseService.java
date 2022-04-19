package com.web.libreria.services;

import java.util.List;

public interface BaseService<E,ID> {
    
    void create (E entity);

    void update (E entity);

    List<E> getAll();
    
    E getById(ID id);

    void deleteById(ID id);

}
