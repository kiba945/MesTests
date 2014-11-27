package org.afpa59.patrice.donnees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Entite {
	
	/****************************************/
	/* D�claration des variables d'instance */
	/****************************************/
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int code;
	
	/************************************/
	/*	D�claration des constructeurs	*/
	/************************************/
	/*** 1er constructeur ***/
	public Entite(){}
	/*** 2�me constructeur avec des param�tres ***/
	public Entite(int code){
		this.code=code;
	}
	
	/************************************/
	/*		D�claration des GETTEURS	*/
	/************************************/
	public int getCode(){return code;}
	
	/************************************/
	/*		D�claration des SETTEURS	*/
	/************************************/
	public void setCode(int code){this.code=code;}
	
	/************************************/
	/*		D�claration des m�thodes	*/
	/************************************/
	/*** M�thode toString() retourne une cha�ne de caract�re  ***/
	public String toString(){return ("Code: "+code);}
	
	public void writeData(PrintWriter out) throws IOException {
		// TODO Auto-generated method stub
		
	}	
}
