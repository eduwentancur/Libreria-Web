package com.web.libreria.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "libros")
public class Libro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;
    @NotBlank(message = "ISBN obligatorio")
    private Long isbn;
    @NotBlank(message = "Titulo obligatorio")
    @Column(length = 100, nullable = false)
    private String titulo;
    @NotBlank(message = "Año obligatorio")
    @Column(name="año", columnDefinition = "YEAR", nullable = false)
    private Integer anio;
    @NotBlank(message = "Añadir ejemplares")
    private Integer ejemplares;
    @NotBlank(message = "Añadir prestados")
    @Column(name = "ejemplares_prestados", length = 100, nullable = false)
    private Integer ejemplaresPrestados;
    @Column(name = "ejemplares_restantes", length = 100, nullable = false)
    private Integer ejemplaresRestantes;
    
    private Boolean alta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Editorial editorial;
    
    public Libro() {
    }

    public Libro(Long id, Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
            Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro [alta=" + alta + ", anio=" + anio + ", autor=" + autor + ", editorial=" + editorial
                + ", ejemplares=" + ejemplares + ", ejemplaresPrestados=" + ejemplaresPrestados
                + ", ejemplaresRestantes=" + ejemplaresRestantes + ", id=" + id + ", isbn=" + isbn + ", titulo="
                + titulo + "]";
    }


}
