package com.groupe3.projetJeuxVideoBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.groupe3.projetJeuxVideoBack.model.Commande;
import com.groupe3.projetJeuxVideoBack.model.User;


public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	
	List<Commande> findByIdClient(User idClient);

}
