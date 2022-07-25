package com.groupe3.projetJeuxVideoBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.groupe3.projetJeuxVideoBack.model.JsonViews;
import com.groupe3.projetJeuxVideoBack.model.User;
import com.groupe3.projetJeuxVideoBack.repo.UserRepository;


@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("")
	@JsonView(JsonViews.UserWithCommande.class)
	public List<User> findall() {
		return repo.findAll();
	}

}
