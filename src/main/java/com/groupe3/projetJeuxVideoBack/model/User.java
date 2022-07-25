package com.groupe3.projetJeuxVideoBack.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class User {

	@Id
	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Pseudo manquant !")
	private String username;
	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Mot de passe manquant !")
	private String password;
	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Veuillez renseigner votre nom")
	private String nom;
	@JsonView(JsonViews.Common.class)
	@NotEmpty (message = "Veuillez renseigner votre prenom")
	private String prenom;
	@JsonView(JsonViews.Common.class)
	@NotEmpty (message = "Veuillez renseigner votre adresse")
	private String adresse;
	@JsonView(JsonViews.Common.class)
	private Boolean isAdmin;
	@JsonView(JsonViews.Common.class)
	private Boolean isBanned;
	
	@JsonView(JsonViews.UserWithCommande.class)
	@OneToMany(mappedBy = "idClient")
	private List<Commande> commandes;

	@Version
	@JsonView(JsonViews.Common.class)
	private int version;

	public User() {
		super();
	}

	public User(String username, String password, String nom, String prenom, String adresse, Boolean isAdmin, Boolean isBanned) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
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

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsBanned() {
		return isBanned;
	}

	public void setIsBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", version=" + version + ", isAdmin=" + isAdmin + ", isBanned=" + isBanned + "]";
	}

}
