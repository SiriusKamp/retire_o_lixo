package com.api.retire.retire_o_lixo.repository;

import com.api.retire.retire_o_lixo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
 
    Optional<Usuario> findByEmail(String email);

}
