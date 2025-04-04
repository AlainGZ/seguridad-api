package com.example.seguridad_api.service;

import com.example.seguridad_api.model.Usuario;
import com.example.seguridad_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsers() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> getUserById(Long id) {
		return usuarioRepository.findById(id);
	}

	public Optional<Usuario> getUserByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	public Usuario saveUser(Usuario user) {
		return usuarioRepository.save(user);
	}

	public void deleteUser(Long id) {
		usuarioRepository.deleteById(id);
	}
}
