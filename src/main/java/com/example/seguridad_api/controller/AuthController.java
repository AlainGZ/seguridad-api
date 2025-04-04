package com.example.seguridad_api.controller;

import com.example.seguridad_api.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	private final UserDetailsService userDetailsService;

	public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
						  UserDetailsService userDetailsService) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userDetailsService = userDetailsService;
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestParam String username, @RequestParam String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		String token = jwtTokenProvider.generateToken(userDetails);

		Map<String, String> response = new HashMap<>();
		response.put("token", token);
		return ResponseEntity.ok(response);
	}

}
