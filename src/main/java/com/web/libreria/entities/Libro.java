package com.web.libreria.entities;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
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
    @NotNull(message = "ISBN obligatorio")
    private Long isbn;
    @NotBlank(message = "Titulo obligatorio")
    @Column(length = 100, nullable = false)
    private String titulo;
    @NotNull(message = "Año obligatorio")
    @Column(name="año", columnDefinition = "YEAR", nullable = false)
    private Integer anio;
    @NotNull
    private Integer ejemplares;
    @Column(name = "ejemplares_prestados", length = 100)
    @NotNull
    private Integer ejemplaresPrestados;
    @Column(name = "ejemplares_restantes", length = 100)
    private Integer ejemplaresRestantes;
    
    private Boolean alta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Editorial editorial;

}
