
package com.web.libreria.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@SQLDelete(sql="UPDATE usuario SET alta = true WHERE id = ?")
public class Usuario {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="El nombre es obligatorio")
    @Column(nullable=false)
    private String nombre;
    
    @NotBlank(message="El apellido es obligatorio")
    @Column(nullable = false)
    private String apellido;
    
    @NotBlank(message = "El email es obligatorio")
    @Column(nullable = false, unique = true)
    private String email;
    
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La clave debe tener al menos 8 caracteres")
    @Column(nullable = false)
    private String contrasenia;
    
    
    private Boolean alta;

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", contrasenia=" + contrasenia + ", alta=" + alta + '}';
    }
    
    
   
    
    
}
