package org.afpa59.patrice.donnees;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.afpa59.patrice.utils.DateUser;

public class Commande extends Entite{

	/****************************************/
	/* D�claration des variables d'instance */
	/****************************************/
	private String codeCde;
	private DateUser dateCde = new DateUser();
	private DateUser dateFact;
	private boolean etatFacture;

	private ArrayList<LigneDeCommande> listeCde = new ArrayList<LigneDeCommande>();


	/************************************/
	/*	D�claration des constructeurs	*/
	/************************************/
	/*** 1er constructeur ***/
	public Commande(){}
	/*** 2�me constructeur avec des param�tres ***/
	public Commande(String code, DateUser dateCde, ArrayList<LigneDeCommande> Cde){
		//		super.getCode();
		this.codeCde=code;
		this.dateCde=dateCde;
		this.listeCde=Cde;
	}

	/************************************/
	/*		D�claration des GETTEURS	*/
	/************************************/
	public String getCodeCde(){return codeCde;}
	public DateUser getDateCde(){return dateCde;}
	public DateUser getDateFact(){return dateFact;}
	public boolean getEtatFacture(){return etatFacture;}

	public ArrayList<LigneDeCommande> getUneCommande(){return listeCde;}

	/************************************/
	/*		D�claration des SETTEURS	*/
	/************************************/
	public void setCodeCde(String code){this.codeCde=code;}
	public void setDateCde(DateUser dateCde){this.dateCde=dateCde;}
	public void setUneCommande(ArrayList<LigneDeCommande> ldc){this.listeCde=ldc;}
	public void setDateFact(DateUser dateFact){this.dateFact = dateFact;}
	public void setEtatFacture(boolean etatFacture){this.etatFacture = etatFacture;}


	/************************************/
	/*		D�calaration des m�thodes	*/
	/************************************/
	/*** M�thode toString() retourne une cha�ne de caract�re  ***/
	public String toString(){
		String st = new String();
		for(int i=0;i<taille();i++){
			st = st + listeCde.get(i).toString()+ "**\n";
		}
		return st;
	}

	public void ajouter(LigneDeCommande lg){listeCde.add(lg);}

	public void supprimer(LigneDeCommande lg){listeCde.remove(lg);}

	public LigneDeCommande retourner(int lg){
		if(taille()>0){
			return listeCde.get(lg);
		}
		return null;
	}

	public String cle() {return null;}

	/*** M�thode taille() retourne la taille de la liste des commandes  ***/
	public int taille(){return listeCde.size();}


	public String etatCommandeFacturee(){
		String st;
		if(etatFacture){
			st=" *** Date facture : "+dateFact+"\n";
		}else{
			st=" *** Non encore Facturee...\n";
		}
		return st;
	}

	/**
	 * M�thode qui lit une ligne du fichier qui correspond � une ligne Article
	 * 
	 * @param ligArticle du type String
	 */
	public void readData(String ligCommande) throws IOException{

		int codeArt;
		int qteArt;
		//		int numlig;

		StringTokenizer t = new StringTokenizer(ligCommande, "|");

		/* **************** DEBUG ********************** */
		System.out.println("Je suis dans de la classse Commande"
				+ " dans la m�thode readData()");
		codeCde= t.nextToken();

		//		numlig=  Integer.parseInt(t.nextToken());

		while(t.hasMoreTokens()){	
			codeArt= Integer.parseInt(t.nextToken());
			qteArt= Integer.parseInt(t.nextToken());
			ajouter(new LigneDeCommande(codeArt,qteArt));
		}
		

		//		ES.affiche(" code cde: "
		//				+ codeCde
		//				+ " num ligne: "
		//				+ numlig
		//				+ " code Article: "
		//				+ codeArt
		//				+ " qte command�e: "
		//				+ qteArt
		//				+ " ");

		//		listeCde.set(numlig, new LigneDeCommande(codeArt,qteArt));


		/* **************** DEBUG ********************** */
	}	

	/**
	 * M�thode qui �crit une ligne d'une commande dans un PrintWriter
	 * 
	 * @param out du type PrintWriter
	 */
	public void writeData(PrintWriter out) throws IOException{
		//		super.writeData(out);

		/* **************** DEBUG ********************** */
		String st="";
		System.out.println("Je suis dans de la classe Commande"
				+ " dans la m�thode writeData()");		



		out.print(dateCde);
		out.print(codeCde);
		
		//		st = codeCde;

		//		ES.affiche(st);

		for (int i = 0; i < listeCde.size(); i++) {

			//			ES.affiche("taille de listCde: "+listeCde.size());

			st = st 
					//					+ "|" 
					//					+ i		// numero de la ligne
					+ "|" 
					+ listeCde.get(i).getCode()
					+ "|"  
					+ listeCde.get(i).getQuantite();
		}		

		out.println(st);

		//		ES.affiche(st);
		/* **************** DEBUG ********************** */
	}



}