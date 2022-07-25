package com.groupe3.projetJeuxVideoBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupe3.projetJeuxVideoBack.model.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
