package org.afpa59.patrice.donnees;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.afpa59.patrice.utils.DateUser;

@Entity
public class Commande extends Entite{

	/****************************************/
	/* D�claration des variables d'instance */
	/****************************************/

	@Column(name = "code")
	private String codeCde;
	
//	@Column(name = "date_cde")
//	private DateUser dateCde = new DateUser();
	
//	private DateUser dateFact;
//	
//	private boolean etatFacture;
//	
//
//	
//
//	private ArrayList<LigneDeCommande> listeCde = new ArrayList<LigneDeCommande>();


	/************************************/
	/*	D�claration des constructeurs	*/
	/************************************/
	/*** 1er constructeur ***/
	public Commande(){}
	/*** 2�me constructeur avec des param�tres ***/
	public Commande(String code, DateUser dateCde, ArrayList<LigneDeCommande> Cde){
		//		super.getCode();
		this.codeCde=code;
//		this.dateCde=dateCde;
//		this.listeCde=Cde;
	}

	/************************************/
	/*		D�claration des GETTEURS	*/
	/************************************/
	public String getCodeCde(){return codeCde;}
//	public DateUser getDateCde(){return dateCde;}
//	public DateUser getDateFact(){return dateFact;}
//	public boolean getEtatFacture(){return etatFacture;}
//
//	public ArrayList<LigneDeCommande> getUneCommande(){return listeCde;}

	/************************************/
	/*		D�claration des SETTEURS	*/
	/************************************/
	public void setCodeCde(String code){this.codeCde=code;}
//	public void setDateCde(DateUser dateCde){this.dateCde=dateCde;}
//	public void setUneCommande(ArrayList<LigneDeCommande> ldc){this.listeCde=ldc;}
//	public void setDateFact(DateUser dateFact){this.dateFact = dateFact;}
//	public void setEtatFacture(boolean etatFacture){this.etatFacture = etatFacture;}


	/************************************/
	/*		D�calaration des m�thodes	*/
	/************************************/
	/*** M�thode toString() retourne une cha�ne de caract�re  ***/
	public String toString(){
		String st = new String();
//		for(int i=0;i<taille();i++){
//			st = st + listeCde.get(i).toString()+ "**\n";
//		}
		return st;
	}

//	public void ajouter(LigneDeCommande lg){listeCde.add(lg);}
//
//	public void supprimer(LigneDeCommande lg){listeCde.remove(lg);}
//
//	public LigneDeCommande retourner(int lg){
//		if(taille()>0){
//			return listeCde.get(lg);
//		}
//		return null;
//	}

	public String cle() {return null;}

	/*** M�thode taille() retourne la taille de la liste des commandes  ***/
//	public int taille(){return listeCde.size();}

}