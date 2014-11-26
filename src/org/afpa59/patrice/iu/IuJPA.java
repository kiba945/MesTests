package org.afpa59.patrice.iu;


import org.afpa59.patrice.services.MonJPA01;
import org.afpa59.patrice.utils.ES;

public class IuJPA extends IuBase{

	/*** Méthode menuGeneral qui renvoie le choix du menu  ***/
	public static void menuGeneral(){
		int rep;

		do{
			rep = choix();
			switch(rep){
			case 1:  new MonJPA01().test(); break;
			case 2:  break;
			case 3:  break;
			case 4:  break;
			case 5:  break;
			case 6:  break;
			case 7:  break;
			case 8:  break;
			case 9:  break;
			case 10:  break;
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
				"01.  JPA persist \n"+
				"02.  JPA merge \n"+
				"03.  JPA remove \n"+
				"04.  JPA find \n"+
				"05.  \n"+
				"06.  \n"+
				"07.  \n"+
				"08.  \n"+
				"09.  \n"+
				"10. \n"+
				"11.  \n"+
				"\t\t FIN .................... 0\n\n"+
				"\t\t             Choix : ............ ";
		return ES.saisie(s, 0, 11);
	}		
}

