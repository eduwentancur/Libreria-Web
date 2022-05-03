
package com.web.libreria.services;

import com.web.libreria.entities.Usuario;
import com.web.libreria.repository.UsuarioRepository;
import static java.util.Collections.emptyList;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public void create(Usuario dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail()))
            throw new IllegalArgumentException("There is already a user associated with the email entered");

        Usuario user = new Usuario();

        user.setEmail(dto.getEmail());
        user.setContrasenia(encoder.encode(dto.getContrasenia()));

        usuarioRepository.save(user);
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("There is no user associated with the email entered"));

        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getContrasenia(), emptyList());
    }
    
    
    
}
