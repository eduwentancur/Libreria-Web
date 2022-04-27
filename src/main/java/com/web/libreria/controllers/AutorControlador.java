package com.web.libreria.controllers;


import com.web.libreria.entities.Autor;
import com.web.libreria.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AutorControlador {

    @Autowired
    private AutorService autorService;
    
    @GetMapping("/crearAutor")
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("from-autor");
        mav.addObject("autor", new Autor());
        mav.addObject("action", "create");
        return mav;
    }

    @GetMapping("/autores")
    public ModelAndView mostrarAutores() {
        ModelAndView mav = new ModelAndView("autores");
        mav.addObject("autores", autorService.getAll());
        return mav;
    }

    @PostMapping("/agregar/autor/create")
    public RedirectView create(Autor autor) {
        autorService.create(autor);
        return new RedirectView("/autores");
    }


    @GetMapping("/eliminar/autor/{id}")
    public RedirectView EliminarAutor(Autor autor ) {
        autorService.deleteById(autor.getId());
        return new RedirectView("/autores");
    }
}
