package br.com.daniel.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.daniel.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCursoNome(String nomeCurso);

	@Query("SELECT t FROM Topico t where t.curso.nome = :nomeCurso")
	List<Topico> findbyNomeCurso(@Param("nomeCurso") String nomeCurso);
}
