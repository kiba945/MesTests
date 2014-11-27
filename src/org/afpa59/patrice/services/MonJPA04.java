package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.utils.ES;

public class MonJPA04 {
	
	public void test() {
		// TODO Auto-generated method stub
		Article article;
		
	    // Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");
		
		EntityManager em = emf.createEntityManager();
				
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		int code = ES.saisie("*** RECHERCHE D'UN ARTICLE ***\n"
				+ "Vous cherchez quel article:", 1, Integer.MAX_VALUE);
		
		article = em.find(Article.class,code);
		
		if (article != null){

			ES.affiche("     ****** Votre Article trouvé******\n"
					+ article.toString());
			
		}else{
			ES.affiche("Article code " + code + " non trouvé");
		}
		
//		em.flush();	//Envoi sur la Base de donnée
//		et.commit();	//Validation de l'envoi
		
		em.close();
		emf.close();

		
	}
}
