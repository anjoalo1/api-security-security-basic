package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.pojo.UsuarioPojo;
import com.example.demo.domain.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	
	private final IUsuarioRepository iUsuarioRepository;
	
	
	public UsuarioService(IUsuarioRepository iUsuarioRepository) {
		this.iUsuarioRepository = iUsuarioRepository;
	}

	@Override
	public List<UsuarioPojo> getAll() {
		// TODO Auto-generated method stub
		return iUsuarioRepository.getAll();
	}
	

	@Override
	public Optional<UsuarioPojo> getUsuario(Long id) {
		// TODO Auto-generated method stub
		return iUsuarioRepository.getUsuario(id);
	}

	@Override
	public UsuarioPojo save(UsuarioPojo newUsuarios) {
		// TODO Auto-generated method stub
		return iUsuarioRepository.save(newUsuarios);
	}

	@Override
	public boolean delete(Long idUsuario) {
		// TODO Auto-generated method stub
		try {
			iUsuarioRepository.delete(idUsuario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
