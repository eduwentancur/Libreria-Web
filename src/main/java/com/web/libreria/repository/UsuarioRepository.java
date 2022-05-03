
package com.web.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.libreria.entities.Usuario;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
    
}
