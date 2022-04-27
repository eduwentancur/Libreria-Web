package com.web.libreria.services;

import java.util.List;
import com.web.libreria.entities.Libro;
import com.web.libreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService implements BaseService<Libro, Long> {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    @Transactional
    public void create(Libro entity) {
        Libro libroNuevo = new Libro();
        libroNuevo.setIsbn(entity.getIsbn());
        libroNuevo.setTitulo(entity.getTitulo());
        libroNuevo.setAnio(entity.getAnio());
        libroNuevo.setEjemplares(entity.getEjemplares());
        libroNuevo.setEjemplaresPrestados(entity.getEjemplaresPrestados());
        libroNuevo.setEjemplaresRestantes(entity.getEjemplares()-entity.getEjemplaresPrestados());
        libroNuevo.setAlta(true);
        libroNuevo.setAutor(entity.getAutor());
        libroNuevo.setEditorial(entity.getEditorial());
        libroRepository.save(libroNuevo);
    }

    @Override
    @Transactional
    public void update(Libro entity) {
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> getAll() {
        return libroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Libro getById(Long id) {
        return libroRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }

    @Transactional
    public void cambiarAlta(Libro libro) {
        
    }
    
}
