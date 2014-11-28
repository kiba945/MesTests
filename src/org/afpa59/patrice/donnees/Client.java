package org.afpa59.patrice.donnees;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Client")
public class Client extends Entite{
	

	/****************************************/
	/* D�claration des variables d'instance */
	/****************************************/
//	@Id
//	@GeneratedValue( strategy = GenerationType.IDENTITY)	//Auto incremente l'ID dans la table
//	@Column(name = "code")
//	private int code; //champ inactif pour eclipselink qui exige @Id sur le champ et refuse sur les getCode()
//	

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "adresse")
	private String adresse;
	
	@OneToMany(mappedBy = "clt")	//un client peut avoir plusieurs cdes	
	private List<Commande> commandes = new ArrayList<Commande>();
	
	/************************************/
	/*	D�claration des constructeurs	*/
	/************************************/
	/*** 1er constructeur ***/
	public Client(){}
	/*** 2�me constructeur avec des param�tres ***/
	public Client(int code, String nomClient, String prenomClient, String adresseClient){
		super(code);
		this.nom=nomClient;
		this.prenom=prenomClient;
		this.adresse=adresseClient;
	}
	
	/************************************/
	/*		D�claration des GETTEURS	*/
	/************************************/
	public String getNom(){return nom;}
	public String getPrenom(){return prenom;}
	public String getAdresse(){return adresse;}
	
	/************************************/
	/*		D�claration des SETTEURS	*/
	/************************************/
	public void setNom(String nomClient){this.nom=nomClient;}
	public void setPrenom(String prenomClient){this.prenom=prenomClient;}
	public void setAdresse(String adresseClient){this.adresse=adresseClient;}
	
	/************************************/
	/*		D�calaration des m�thodes	*/
	/************************************/
	/*** M�thode toString() retourne une cha�ne de caract�re  ***/
	public String toString(){return (super.toString()+" Nom: "+nom+
			" Pr�nom: "+prenom+" Adresse: "+adresse);}	
	
	
	
//	/**
//	* M�thode qui �crit une ligne client dans un PrintWriter
//	* 
//	* @param out du type PrintWriter
//	*/
//	public void writeData(PrintWriter out) throws IOException{
//		super.writeData(out);
//		out.println(nom + "|" + prenom + "|" + adresse);		
//	}
//
//
//	
//	/**
//	* M�thode qui lit une ligne du fichier qui correspond � une ligne Client
//	* 
//	* @param ligClient du type String
//	*/
//	public void readData(String ligClient) throws IOException{
//		
//		StringTokenizer t = new StringTokenizer(ligClient, "|");
//		int code = Integer.parseInt(t.nextToken());
//		
//		super.setCode(code);
//		nom = t.nextToken();
//		prenom = t.nextToken();
//		adresse = t.nextToken();
//	}	
}
