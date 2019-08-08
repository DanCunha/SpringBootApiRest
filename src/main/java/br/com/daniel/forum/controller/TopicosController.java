package br.com.daniel.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.daniel.forum.dto.DetalhesDoTopicoDto;
import br.com.daniel.forum.dto.TopicoDTO;
import br.com.daniel.forum.form.TopicoForm;
import br.com.daniel.forum.model.Topico;
import br.com.daniel.forum.repository.CursoRepository;
import br.com.daniel.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDTO> lista(String nomeCurso){
		if(nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();		
			return TopicoDTO.converter(topicos) ;			
		}else {
			List<Topico> topicos = topicoRepository.findbyNomeCurso(nomeCurso);		
			return TopicoDTO.converter(topicos) ;
		}
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
	
	@GetMapping("/{id}")
	public DetalhesDoTopicoDto detalhar(@PathVariable Long id) {
		Topico topico = topicoRepository.getOne(id);
		return new DetalhesDoTopicoDto(topico);
	}
}