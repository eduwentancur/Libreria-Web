package com.web.libreria.services;

import java.util.List;

import com.web.libreria.entities.Autor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService implements BaseService<Autor, Long> {

    @Override
    @Transactional
    public void create(Autor entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @Transactional
    public void update(Autor entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<Autor> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Autor getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    
}