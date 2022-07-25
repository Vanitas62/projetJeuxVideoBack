package com.groupe3.projetJeuxVideoBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.groupe3.projetJeuxVideoBack.model.Commande;
import com.groupe3.projetJeuxVideoBack.model.JsonViews;
import com.groupe3.projetJeuxVideoBack.repo.CommandeRepository;


@RestController
@CrossOrigin
@RequestMapping("/commandes")
public class CommandeRestController {
	
	@Autowired
	private CommandeRepository repo;
	
	@GetMapping("")
	@JsonView(JsonViews.CommandeWithUser.class)
	public List<Commande> findall() {
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	@JsonView(JsonViews.CommandeWithUser.class)
	public Commande findById(@PathVariable(name="id") int id)
	{
		return repo.findById(id).get();
	}
	
	@GetMapping("/commande/{idClient}")
	@JsonView(JsonViews.CommandeWithUser.class)
	public List<Commande> findByIdClient(@PathVariable(name="idClient") String idClient)
	{
		//return (List<Commande>) repo.findByIdClient(idClient);
	}
	
	@PostMapping("")
	public String create(@RequestBody Commande c)
	{
		repo.save(c);
		return "Commande créée !";
	}
	
	@PutMapping("")
	public String update(@RequestBody Commande c)
	{
		repo.save(c);
		return "Commande modifiée !";
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable(name="id") int id)
	{
		repo.delete(repo.findById(id).get());
		
		return new ResponseEntity<String>("Commande supprimée !", HttpStatus.I_AM_A_TEAPOT);
	}

}
