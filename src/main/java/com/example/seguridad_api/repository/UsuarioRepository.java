package com.example.seguridad_api.repository;

import com.example.seguridad_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

Optional<Usuario> findByUsername(String username);
	Optional<Usuario> findByEmail(String email);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
}
