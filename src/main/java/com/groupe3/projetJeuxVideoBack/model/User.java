package com.groupe3.projetJeuxVideoBack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;





@Entity
public class User {

	@Id
	@NotEmpty(message = "Pseudo manquant !")
	private String username;
	@NotEmpty(message = "Mot de passe manquant !")
	private String password;
	@NotEmpty(message = "Veuillez renseigner votre nom")
	private String nom;
	@NotEmpty (message = "Veuillez renseigner votre prenom")
	private String prenom;
	@NotEmpty (message = "Veuillez renseigner votre adresse")
	private String adresse;

	@Version
	private int version;

	public User() {
		super();
	}

	public User(String username, String password, String nom, String prenom, String adresse) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", version=" + version + "]";
	}

}
