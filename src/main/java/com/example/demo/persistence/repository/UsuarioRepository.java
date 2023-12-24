package com.example.demo.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.pojo.UsuarioPojo;
import com.example.demo.domain.repository.IUsuarioRepository;
import com.example.demo.persistence.entity.Usuario;
import com.example.demo.persistence.mapper.IUsuarioMapper;


//import lombok.AllArgsConstructor;


@Repository
public class UsuarioRepository implements IUsuarioRepository{
	//crud usuarioresporitory
	private final IUsuarioCrudRepository  iUsuarioCrudRepository;
	//usuariomapper
	private final IUsuarioMapper iUsuarioMapper;


	@Autowired
	public UsuarioRepository(IUsuarioCrudRepository iUsuarioCrudRespository, IUsuarioMapper iUsuarioMapper) {
		this.iUsuarioCrudRepository = iUsuarioCrudRespository;
		this.iUsuarioMapper = iUsuarioMapper;
	}
	
	/*
	 * sobrescritura de metodos declarados en domain.repository
	 * */

	@Override
	public List<UsuarioPojo> getAll() {
		// TODO Auto-generated method stub
		return iUsuarioMapper.toUsuarioPojo(iUsuarioCrudRepository.findAll());
	}

	@Override
	public Optional<UsuarioPojo> getUsuario(Long id) {
		// TODO Auto-generated method stub
		return iUsuarioCrudRepository.findById(id).map(Usuario->iUsuarioMapper.toUsuarioPojo(Usuario));
		//return Optional.empty();
	}

	@Override
	public UsuarioPojo save(UsuarioPojo newUsuarios) {
		// TODO Auto-generated method stub
		Usuario usuario = iUsuarioMapper.toUsuario(newUsuarios);
		return iUsuarioMapper.toUsuarioPojo(iUsuarioCrudRepository.save(usuario));
	}

	@Override
	public void delete(Long idUsuario) {
		// TODO Auto-generated method stub
		iUsuarioCrudRepository.deleteById(idUsuario);
	}
		


}
