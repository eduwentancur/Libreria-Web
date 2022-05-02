package com.web.libreria.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "autores")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_autor") 
    private Long id;
    @NotBlank(message = "Nombre obligatorio")
    @Column(name="autor_nombre")
    private String nombre;
    private Boolean alta;
   
    @Override
    public String toString() {
        return "Autor [alta=" + alta + ", id=" + id + ", nombre=" + nombre + "]";
    }
    
}
