package com.groupe3.projetJeuxVideoBack.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@NamedQuery(
name="Commande.findByIdClient",
query="select c from Commande c where c.idClient = :idClient")
public class Commande {

	@Id
	@JsonView(JsonViews.Common.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	@JsonView(JsonViews.CommandeWithUser.class)
	private User idClient;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonView(JsonViews.Common.class)
	private Date date;
	@JsonView(JsonViews.Common.class)
	private double prixTotal;
	@JsonView(JsonViews.Common.class)
	private String infos;

	@Version
	@JsonView(JsonViews.Common.class)
	private int version;

	public Commande() {
		super();
	}

	public Commande(int id, User idClient, Date date, double prixTotal, String infos) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.date = date;
		this.prixTotal = prixTotal;
		this.infos = infos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getIdClient() {
		return idClient;
	}

	public void setIdClient(User idClient) {
		this.idClient = idClient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", idClient=" + idClient + ", date=" + date + ", prixTotal=" + prixTotal
				+ ", infos=" + infos + ", version=" + version + "]";
	}

}
