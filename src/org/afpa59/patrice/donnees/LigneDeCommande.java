package org.afpa59.patrice.donnees;



public class LigneDeCommande extends Entite{
	
	/****************************************/
	/* Déclaration des variables d'instance */
	/****************************************/
	private int quantite;
	
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
