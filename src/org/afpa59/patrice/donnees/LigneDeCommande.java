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
	/* D�claration des variables d'instance */
	/****************************************/
	@Column(name = "quantite")
	private int quantite;
	
	@ManyToOne(cascade = CascadeType.ALL)	// 
	@JoinColumn( name= "code_article")
	private Article art;
	
	/************************************/
	/*	D�claration des constructeurs	*/
	/************************************/
	
	
	/*** 1er constructeur ***/
	public LigneDeCommande(){}
	
	
	/*** 2�me constructeur avec des param�tres ***/
	public LigneDeCommande(int code, int quantite){
		super(code);
		this.quantite=quantite;
	}
	
	
	/************************************/
	/*		D�claration des GETTEURS	*/
	/************************************/
	public int getQuantite(){return quantite;}
	
	/************************************/
	/*		D�claration des SETTEURS	*/
	/************************************/
	public void setQuantite(int quantite){this.quantite=quantite;}
	
	/************************************/
	/*		D�calaration des m�thodes	*/
	/************************************/
	
	/*** M�thode toString() retourne une cha�ne de caract�re  ***/
	public String toString(){return (super.toString()+" Quantit�: "+quantite);}
	
}
