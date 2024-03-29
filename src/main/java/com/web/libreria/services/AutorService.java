package com.web.libreria.services;

import java.util.List;
import com.web.libreria.entities.Autor;
import com.web.libreria.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorService implements BaseService<Autor, Long> {

    private final AutorRepository autorRepository;
    
   

    @Override
    @Transactional
    public void create(Autor entity) {
        Autor autorNuevo = new Autor();
        autorNuevo.setNombre(entity.getNombre());
        autorNuevo.setAlta(entity.getAlta());
        autorRepository.save(autorNuevo);
    }

    @Override
    @Transactional
    public void update(Autor entity) {
    }

    @Override
    @Transactional(readOnly = true)
    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Autor getById(Long id) {
        return autorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Autor BuscarAutor(Autor autor) {
        return autorRepository.findById(autor.getId()).orElse(null);
    }
}