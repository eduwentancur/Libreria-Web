
package com.web.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.libreria.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    
    
}
