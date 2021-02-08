package br.com.loteria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loteria.entities.Bilhete;
import br.com.loteria.entities.Usuario;
import br.com.loteria.repositories.BilheteRepository;
import br.com.loteria.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private BilheteRepository bilheteRepository;
	
	
	public Usuario insert(Usuario obj) {
		Bilhete bilhete = new Bilhete();
		Usuario usuario = userRepository.findByEmail(obj.getEmail());
		if(usuario == null) {
			obj.getBilhetes().add(bilhete);
			bilhete.setUsuario(obj);
			obj = userRepository.save(obj);
			return obj;	
	}
		
		usuario.getBilhetes().add(bilhete);
		bilhete.setUsuario(usuario);
		usuario = userRepository.save(usuario);
		return usuario;
		
	}
	
	public List<Usuario> listAll(){
		return userRepository.findAll();
	}
	
	public Usuario buscarUsuario(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<Bilhete> listarBilhetes(String email){
		Usuario usuario = userRepository.findByEmail(email);
		List<Bilhete> bilhetes = (List<Bilhete>) bilheteRepository.findByUsuarioIdOrderByIdDesc(usuario.getId());
		return bilhetes;
	}
	

}
