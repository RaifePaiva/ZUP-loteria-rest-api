package br.com.loteria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loteria.dto.BilheteDto;
import br.com.loteria.dto.UsuarioDto;
import br.com.loteria.dto.UsuarioResponseDto;
import br.com.loteria.entities.Usuario;
import br.com.loteria.services.UsuarioService;

@RestController
@RequestMapping( value = "/apostador")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public UsuarioResponseDto insert(@RequestBody Usuario obj){
		obj = userService.insert(obj);
		UsuarioResponseDto dto = new UsuarioResponseDto(obj);
		return dto;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<UsuarioDto> listAll(){
		return UsuarioDto.convert(userService.listAll());
	}
	
	/*@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Usuario buscarUsuario(@PathVariable String email) {
		Usuario usuario = userService.buscarUsuario(email);
		return usuario;
	}*/
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<BilheteDto> buscarUsuarioBilhetes(@PathVariable String email){
		return BilheteDto.convert(userService.listarBilhetes(email));
	}
	
	
}
