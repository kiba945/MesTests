package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.utils.ES;

public class MonJPA02 {

	public void test() {

		// Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Article");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();

		int code = ES.saisie("Votre code Article:", 1, Integer.MAX_VALUE);		
		
		Article article;
		article = em.find(Article.class,code);
		
		if (article == null){
			ES.affiche("Article non trouvé");
		}else{
			String designation = ES.saisie("Votre désignation Article:");
			Float prix = ES.saisie("Votre prix Article", 1, Float.MAX_VALUE);
			
			article.setDesignation(designation);
			article.setPrix(prix);
			
			em.merge(article);	
			
			em.flush();	//Envoi sur la Base de donnée
			et.commit();	//Validation de l'envoi

			ES.affiche("     ****** Votre Article ******\n"
					+ "code: "
					+ article.getCode()
					+ "\n     ****** a bien été modifié ******");
		}

		em.close();

	}

}