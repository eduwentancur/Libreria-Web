package com.web.libreria.services;

import java.util.List;
import com.web.libreria.entities.Editorial;
import com.web.libreria.repository.EditorialRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditorialService implements BaseService<Editorial, Long> {

    private final EditorialRepository editorialRepository;
    

    @Override
    @Transactional
    public void create(Editorial entity) {
        Editorial editorial= new Editorial();
        editorial.setNombre(entity.getNombre());
        editorial.setAlta(entity.getAlta());
        editorialRepository.save(editorial);
    }

    @Override
    @Transactional
    public void update(Editorial entity) {
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<Editorial> getAll() {
        return editorialRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Editorial getById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
    }

    @Transactional
    public void alataBaja(Editorial entity) {
        if(entity.getAlta()==true){
            entity.setAlta(false);

        }else if(entity.getAlta()==false){
            entity.setAlta(true);
        }
        editorialRepository.save(entity);
    }
    
    @Transactional(readOnly = true)
    public Editorial BuscarEditorial(Editorial editorial) {
        return editorialRepository.findById(editorial.getId()).orElse(null);
    }

}