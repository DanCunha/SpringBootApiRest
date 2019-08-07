package br.com.daniel.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniel.forum.controller.dto.TopicoDTO;
import br.com.daniel.forum.model.Curso;
import br.com.daniel.forum.model.Topico;
import br.com.daniel.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDTO> lista(String nomeCurso){
		if(nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();		
			return TopicoDTO.converter(topicos) ;			
		}else {
			List<Topico> topicos = topicoRepository.findbyNomeCurso(nomeCurso);		
			return TopicoDTO.converter(topicos) ;
		}
	}
}
