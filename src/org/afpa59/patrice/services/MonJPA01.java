package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.utils.ES;

public class MonJPA01 {
	
	public void test() {
		// TODO Auto-generated method stub
		
		
	    // Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Article");
		
		EntityManager em = emf.createEntityManager();
				
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Article article = CreerArticle();	
			
		em.persist(article);
	
		em.flush();	//Envoi sur la Base de donn�e
		et.commit();	//Validation de l'envoi
		
		em.close();
		
		ES.affiche("     ****** Votre Article ******\n"
		+ article.toString()
		+ "\n     ****** a bien �t� cr�e ******");
		
	}

	/**
	 * @return
	 */
	private Article CreerArticle() {
		
//		int code = ES.saisie("Votre code Article:", 1, Integer.MAX_VALUE);
		String designation = ES.saisie("Votre d�signation Article:");
		Float prix = ES.saisie("Votre prix Article", 1, Float.MAX_VALUE);
		
		Article article;
		
		article = new Article();
		
//		article.setCode(code);
		article.setDesignation(designation);
		article.setPrix(prix);
		
		return article;
	}
}
