package com.groupe3.projetJeuxVideoBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupe3.projetJeuxVideoBack.model.Article;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
