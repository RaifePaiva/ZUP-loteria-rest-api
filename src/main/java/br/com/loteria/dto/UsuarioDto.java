package br.com.loteria.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.loteria.entities.Bilhete;
import br.com.loteria.entities.Usuario;

public class UsuarioDto {
	
	private String email;
	private List<Bilhete> bilhetes;

	public UsuarioDto(Usuario usuario) {
		this.email = usuario.getEmail();
		this.bilhetes = usuario.getBilhetes();
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public List<Bilhete> getBilhetes() {
		return bilhetes;
	}

	public static List<UsuarioDto> convert(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
	
	

}
