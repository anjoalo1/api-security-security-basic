package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.pojo.UsuarioPojo;


public interface IUsuarioRepository {
	
	
	
	
	List<UsuarioPojo> getAll();
	
	
	Optional<UsuarioPojo> getUsuario(Long id);
	
	
	UsuarioPojo save(UsuarioPojo newUsuarios);
	
	
	void delete(Long idUsuario);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
