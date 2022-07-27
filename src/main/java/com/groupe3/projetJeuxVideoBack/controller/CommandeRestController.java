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
import com.groupe3.projetJeuxVideoBack.repo.UserRepository;


@RestController
@CrossOrigin
@RequestMapping("/commandes")
public class CommandeRestController {
	
	@Autowired
	private CommandeRepository repo;
	@Autowired
	private UserRepository repoUser;
	
	@GetMapping("")
	@JsonView(JsonViews.CommandeWithUser.class)
	public List<Commande> findall() {
		return repo.findAll();
	}
	
	@GetMapping("/numero/{id}")
	@JsonView(JsonViews.CommandeWithUser.class)
	public Commande findById(@PathVariable(name="id") int id)
	{
		return repo.findById(id).get();
	}
	
	@GetMapping("{idClient}")
	@JsonView(JsonViews.CommandeWithUser.class)
	public List<Commande> findByClient(@PathVariable(name="idClient") String idClient)
	{
		return repo.findByIdClient(repoUser.findById(idClient).get());
	}
	
	@PostMapping("")
	public String create(@RequestBody Commande c)
	{
		repo.save(c);
		return null;
	}
	
	@PutMapping("")
	public String update(@RequestBody Commande c)
	{
		repo.save(c);
		return null;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable(name="id") int id)
	{
		repo.delete(repo.findById(id).get());
		
		return null;
	}

}
