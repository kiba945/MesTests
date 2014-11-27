package org.afpa59.patrice.iu;


import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.services.MonJPA01;
import org.afpa59.patrice.services.MonJPA02;
import org.afpa59.patrice.services.MonJPA03;
import org.afpa59.patrice.services.MonJPA04;
import org.afpa59.patrice.services.MonJPA05;
import org.afpa59.patrice.services.MonJPA06;
import org.afpa59.patrice.services.MonJPA07;
import org.afpa59.patrice.services.MonJPA08;
import org.afpa59.patrice.utils.ES;

public class IuJPA extends IuBase{

	/*** Méthode menuGeneral qui renvoie le choix du menu  ***/
	public static void menuGeneral(){
		int rep;

		do{
			rep = choix();
			switch(rep){
			case 1:  new MonJPA01().test(); break;
			case 2:  new MonJPA02().test(); break;
			case 3:  new MonJPA03().test(); break;
			case 4:  new MonJPA04().test(); break;
			case 5:  new MonJPA05().test(); break;
			case 6:  new MonJPA06().test(); break;
			case 7:  new MonJPA07().test(); break;
			case 8:  new MonJPA08().test(); break;
			case 9:  break;
			case 10: break;
			case 11:  			break;
			case 0: break;
			//default:System.out.println("\n CHOIX INEXISTANT!!!\n");
			}
		}while(rep != 0);
	}

	/*** Méthode menuGeneral qui affiche un menu avec 2 choix
	 * et retourne un entier qui correspondant au choix ***/
	 static int choix(){
		String s = "\n\t\t\t *** MES JPA *** \n\n"+
				"01.  JPA instuction persist(Object) \n"+
				"02.  JPA instruction merge(Object) \n"+
				"03.  JPA instruction remove(Object) \n"+
				"04.  JPA instrution find(Article.class, code) \n"+
				"05.  JPA instruction JPQL(SQL) ... à venir ... \n"+
				"06.  JPA instruction namedQuerynativeSQL() ... à venir ... \n"+
				"07.  JPA SELECT \n"+
				"08.  JPA @ManyToOne\n"+
				"09.  \n"+
				"10. \n"+
				"11.  \n"+
				"\t\t FIN .................... 0\n\n"+
				"\t\t             Choix : ............ ";
		return ES.saisie(s, 0, 11);
	}		
}

