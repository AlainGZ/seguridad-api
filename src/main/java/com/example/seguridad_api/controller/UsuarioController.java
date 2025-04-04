package com.example.seguridad_api.controller;

import com.example.seguridad_api.model.Usuario;
import com.example.seguridad_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> getAllUsers() {
		return usuarioService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.getUserById(id);
		return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Usuario createUser(@RequestBody Usuario user) {
		return usuarioService.saveUser(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		usuarioService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
