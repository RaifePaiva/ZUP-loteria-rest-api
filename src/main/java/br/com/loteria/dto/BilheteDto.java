package br.com.loteria.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.loteria.entities.Bilhete;

public class BilheteDto {
	
	private Long id;
	private Integer numeroBilhete;
	private LocalDate dataCriacao;
	
	
	public BilheteDto(Bilhete bilhete) {
		this.id = bilhete.getId();
		this.numeroBilhete = bilhete.getNumeroBilhete();
		this.dataCriacao = bilhete.getDataCriacao();
	}


	public Long getId() {
		return id;
	}


	public Integer getNumeroBilhete() {
		return numeroBilhete;
	}


	public LocalDate getDataCriacao() {
		return dataCriacao;
	} 
	
	public static List<BilheteDto> convert(List<Bilhete> bilhetes) {
		return bilhetes.stream().map(BilheteDto::new).collect(Collectors.toList());
	}	

}
