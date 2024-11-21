package com.emilio.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.emilio.modelos.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
	boolean existsByNombreUsuario(String nombreUsuario);
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
