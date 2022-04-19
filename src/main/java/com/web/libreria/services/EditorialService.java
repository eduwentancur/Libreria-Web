package com.web.libreria.services;

import java.util.List;


import com.web.libreria.entities.Editorial;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class EditorialService implements BaseService<Editorial, Long> {

    @Override
    @Transactional
    public void create(Editorial entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @Transactional
    public void update(Editorial entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<Editorial> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Editorial getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }




}