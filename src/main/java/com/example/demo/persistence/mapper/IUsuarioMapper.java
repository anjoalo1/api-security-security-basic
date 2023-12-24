package com.example.demo.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.domain.pojo.UsuarioPojo;
import com.example.demo.persistence.entity.Usuario;

@Mapper(componentModel="spring")
public interface IUsuarioMapper {
	
	/*
	 * recibe un objeto Usuario y lo convierte a
	 * un objeto UsuarioPojo
	 * */
	@Mapping(source ="id", target = "id")
	@Mapping(source = "nombre", target = "nombre")
	UsuarioPojo toUsuarioPojo(Usuario usuario);
	
	/*
	 * recibe un objeto UsuarioPojo y lo convierte
	 * a un objeto Usuario
	 * */
	@InheritInverseConfiguration
	Usuario toUsuario(UsuarioPojo usuarioPojo);
	
	List<UsuarioPojo> toUsuarioPojo(List<Usuario> usuario);

}
