package br.com.loteria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loteria.entities.Bilhete;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long> {
	
	
	List<Bilhete> findByUsuarioIdOrderByIdDesc(Long id);

}
