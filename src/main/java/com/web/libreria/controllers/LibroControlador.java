package com.web.libreria.controllers;

import java.util.List;

import com.web.libreria.entities.Autor;
import com.web.libreria.entities.Editorial;
import com.web.libreria.entities.Libro;
import com.web.libreria.services.AutorService;
import com.web.libreria.services.EditorialService;
import com.web.libreria.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LibroControlador {
    
    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/crearLibro")
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("form-libro");
        List<Autor> ListaAutores = autorService.getAll();
        List<Editorial> ListaEditoriales = editorialService.getAll();
        mav.addObject("libro", new Libro());
        mav.addObject("action", "create");
        mav.addObject("autores", ListaAutores);
        mav.addObject("editoriales", ListaEditoriales);
        return mav;
    }

    @PostMapping("/agregar/libro/create")
    public RedirectView create(Libro libro) {
        libroService.create(libro);
        return new RedirectView("/libros");
    }

    @GetMapping("/libros")
    public ModelAndView mostrarAutores() {
        ModelAndView mav = new ModelAndView("libros");
        mav.addObject("libros", libroService.getAll());
        return mav;
    }


}
