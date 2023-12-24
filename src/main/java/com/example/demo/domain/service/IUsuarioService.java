package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;



import com.example.demo.domain.pojo.UsuarioPojo;

public interface IUsuarioService {
	
	List<UsuarioPojo> getAll();
	
	
	Optional<UsuarioPojo> getUsuario(Long id);
	
	
	UsuarioPojo save(UsuarioPojo newUsuarios);
	
	
	
	
	boolean delete(Long idUsuario);

	
}
