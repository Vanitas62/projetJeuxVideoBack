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
	
	@GetMapping("{username}/{password}")
	@JsonView(JsonViews.UserWithCommande.class)
	public User findByUsernameAndPassword(@PathVariable(name = "username") String username,@PathVariable(name = "password") String password) {
		return repo.findByUsernameAndPassword(username, password);
	}
	
	@PostMapping("")
	public String create(@RequestBody User u) {
		repo.save(u);
		return "Utilisateur créé !";
	}
	
	@PutMapping("")
	public String update(@RequestBody User u) {
		repo.save(u);
		return "Utilisateur modifié !";
	}
	
	@DeleteMapping("{username}")
	public ResponseEntity<String> delete(@PathVariable(name = "username") String username) {
		repo.delete(repo.findById(username).get());
		return new ResponseEntity<String>("Utilisateur supprimé !", HttpStatus.I_AM_A_TEAPOT);
	}

}
