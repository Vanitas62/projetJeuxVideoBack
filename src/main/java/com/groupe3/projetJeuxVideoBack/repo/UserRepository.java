package com.groupe3.projetJeuxVideoBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupe3.projetJeuxVideoBack.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
