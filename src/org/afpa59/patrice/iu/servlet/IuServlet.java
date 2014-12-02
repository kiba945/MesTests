package org.afpa59.patrice.iu.servlet;

import org.afpa59.patrice.services.MonJDBC01;
import org.afpa59.patrice.services.MonJDBC02;
import org.afpa59.patrice.utils.ES;

public class IuServlet {

	/*** Méthode menuGeneral qui renvoie le choix du menu  ***/
	public static void menuGeneral(){
		int rep;

		do{
			rep = choix();
			switch(rep){
			case 1:  new MonServlet01().test(); break;
			case 2:  new MonServlet02().test(); break;
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
		String s = "\n\t\t\t *** MES JDBC *** \n\n"+
				"01. Test Servlet BONJOUR \n"+
				"02. Test Servlet  \n"+
				"03. Test Servlet \n"+
				"04. Test Servlet \n"+
				"05. Test Servlet \n"+
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

