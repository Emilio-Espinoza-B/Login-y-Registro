package com.emilio.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilio.modelos.Usuario;
import com.emilio.repositorios.RepositorioUsuario;

@Service
public class ServicioUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public Usuario registrarUsuario(Usuario usuario) {
		return repositorioUsuario.save(usuario);
	}
	
	public boolean nombreUsuarioExistente(String nombreUsuario) {
		return repositorioUsuario.existsByNombreUsuario(nombreUsuario);
	}

	public Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario) {
		return repositorioUsuario.findByNombreUsuario(nombreUsuario);
	}
}
