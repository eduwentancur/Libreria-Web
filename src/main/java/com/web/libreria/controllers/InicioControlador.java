package com.web.libreria.controllers;

import com.web.libreria.entities.Autor;
import com.web.libreria.entities.Editorial;
import com.web.libreria.services.AutorService;
import com.web.libreria.services.EditorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class InicioControlador {
        
    @Autowired
    AutorService autorService;
    @Autowired
    EditorialService editorialService;

    @GetMapping("/")
    public String inicio(){
        return "index";
    }

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

    @PostMapping("/agregar/editorial/create")
    public RedirectView create(Editorial editorial) {
        editorialService.create(editorial);
        return new RedirectView("/editoriales");
    }

    @GetMapping("/crearEditorial")
    public ModelAndView formEditorial() {
        ModelAndView mav = new ModelAndView("form-editorial");
        mav.addObject("editorial", new Editorial());
        mav.addObject("action", "create");
        return mav;
    }

    @GetMapping("/editoriales")
    public ModelAndView mostrarEditoriales() {
        ModelAndView mav = new ModelAndView("editoriales");
        mav.addObject("editoriales", editorialService.getAll());
        return mav;
    }

}
