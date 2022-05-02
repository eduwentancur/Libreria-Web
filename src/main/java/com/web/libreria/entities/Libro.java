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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "libros")
public class Libro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;
    @NotEmpty(message = "ISBN obligatorio")
    private Long isbn;
    @NotBlank(message = "Titulo obligatorio")
    @Column(length = 100, nullable = false)
    private String titulo;
    @NotNull(message = "Año obligatorio")
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


    @Override
    public String toString() {
        return "Libro [alta=" + alta + ", anio=" + anio + ", autor=" + autor + ", editorial=" + editorial
                + ", ejemplares=" + ejemplares + ", ejemplaresPrestados=" + ejemplaresPrestados
                + ", ejemplaresRestantes=" + ejemplaresRestantes + ", id=" + id + ", isbn=" + isbn + ", titulo="
                + titulo + "]";
    }


}
