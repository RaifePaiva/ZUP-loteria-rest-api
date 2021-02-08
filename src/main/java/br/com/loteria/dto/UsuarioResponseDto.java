package br.com.loteria.dto;

import java.util.List;

import br.com.loteria.entities.Bilhete;
import br.com.loteria.entities.Usuario;

public class UsuarioResponseDto {
	
	private String email;
	private Bilhete bilhete;
	
	
	public UsuarioResponseDto(Usuario usuario) {
		this.email = usuario.getEmail();
		this.bilhete = retornaBilheteCadastrado(usuario.getBilhetes());
	}
	
	
	public String getEmail() {
		return email;
	}
	public Bilhete getBilhete() {
		return bilhete;
	}

	
	private Bilhete retornaBilheteCadastrado(List<Bilhete> bilhetes) {
		int ultimaPosicaoDaLista = bilhetes.size()-1;
		Bilhete bilhete = bilhetes.remove(ultimaPosicaoDaLista);
		
		return bilhete;
	}
	
	
	

}
