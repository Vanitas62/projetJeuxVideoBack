package com.groupe3.projetJeuxVideoBack.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String idClient;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private double prixTotal;
	private String infos;

	@Version
	private int version;

	public Commande() {
		super();
	}

	public Commande(int id, String idClient, Date date, double prixTotal, String infos) {
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

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
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
