package com.groupe3.projetJeuxVideoBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
