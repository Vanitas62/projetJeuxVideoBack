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

import com.groupe3.projetJeuxVideoBack.model.Article;
import com.groupe3.projetJeuxVideoBack.repo.ArticleRepository;


@RestController
@CrossOrigin
@RequestMapping("/articles")
public class ArticleRestController {
	
	@Autowired
	private ArticleRepository repo;
	
	@GetMapping("")
	public List<Article> findAll()
	{
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	public Article findById(@PathVariable(name="id") int id)
	{
		return repo.findById(id).get();
	}
	
	@PostMapping("")
	public String create(@RequestBody Article a)
	{
		repo.save(a);
		return "Article créé !";
	}
	
	@PutMapping("")
	public String update(@RequestBody Article a)
	{
		repo.save(a);
		return "Article modifié !";
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable(name="id") int id)
	{
		repo.delete(repo.findById(id).get());
		
		return new ResponseEntity<String>("article supprimé !", HttpStatus.I_AM_A_TEAPOT);
	}

}
