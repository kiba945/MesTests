package org.afpa59.patrice.donnees;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "LigneDeCommande")
public class LigneDeCommande extends Entite{
	
	/****************************************/
	/* Déclaration des variables d'instance */
	/****************************************/
	@Column(name = "quantite")
	private int quantite;
	
	@ManyToOne(cascade = CascadeType.ALL)	// 
	@JoinColumn( name= "code_article")
	private Article art;
	
	/************************************/
	/*	Déclaration des constructeurs	*/
	/************************************/
	
	
	/*** 1er constructeur ***/
	public LigneDeCommande(){}
	
	
	/*** 2ème constructeur avec des paramètres ***/
	public LigneDeCommande(int code, int quantite){
		super(code);
		this.quantite=quantite;
	}
	
	
	/************************************/
	/*		Déclaration des GETTEURS	*/
	/************************************/
	public int getQuantite(){return quantite;}
	
	/************************************/
	/*		Déclaration des SETTEURS	*/
	/************************************/
	public void setQuantite(int quantite){this.quantite=quantite;}
	
	/************************************/
	/*		Décalaration des méthodes	*/
	/************************************/
	
	/*** Méthode toString() retourne une chaîne de caractère  ***/
	public String toString(){return (super.toString()+" Quantité: "+quantite);}
	
}
