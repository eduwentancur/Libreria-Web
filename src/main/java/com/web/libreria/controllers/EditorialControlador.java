package com.web.libreria.controllers;

import com.web.libreria.entities.Editorial;
import com.web.libreria.services.EditorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EditorialControlador {

    @Autowired
    private EditorialService editorialService;
    
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

    @GetMapping("/cambiarAlta/{id}")
    public RedirectView AltaYBaja(Editorial editorial ) {
        editorial = editorialService.BuscarEditorial(editorial);
        editorialService.alataBaja(editorial);
        return new RedirectView("/editoriales");
    }

    @GetMapping("/eliminar/{id}")
    public RedirectView eliminnar(Editorial editorial ) {
        editorial = editorialService.BuscarEditorial(editorial);
        editorialService.deleteById(editorial.getId());
        return new RedirectView("/editoriales");
    }


}
