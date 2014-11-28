package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.utils.ES;

public class MonJPA01 {
	
	public void test() {
		// TODO Auto-generated method stub
		String elt = "";
		
	    // Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");
		
		EntityManager em = emf.createEntityManager();
				
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		elt = ES.saisie("Quel entite? (art,clt,cde) ");
		
		switch (elt) {
		case "art":
			Article article = creerArticle();	
			em.persist(article);
			
			em.flush();	//Envoi sur la Base de donnée
			et.commit();	//Validation de l'envoi
			
			ES.affiche("     ****** Votre Article ******\n"
			+ article.toString()
			+ "\n     ****** a bien été crée ******");
			
			break;

		case "clt":
			Client clt = creerClient();	
			em.persist(clt);	
			
			em.flush();	//Envoi sur la Base de donnée
			et.commit();	//Validation de l'envoi
			
			ES.affiche("     ****** Votre client ******\n"
			+ clt.toString()
			+ "\n     ****** a bien été crée ******");
			
			break;
			
		case "cde":
			
			break;
		}
		

		em.close();
		emf.close();

		
	}

	/**
	 * @return
	 */
	private Article creerArticle() {
		
//		int code = ES.saisie("Votre code Article:", 1, Integer.MAX_VALUE);
		String designation = ES.saisie("Votre désignation Article:");
		Float prix = ES.saisie("Votre prix Article", 1, Float.MAX_VALUE);
		
		Article article;
		
		article = new Article();
		
//		article.setCode(code);
		article.setDesignation(designation);
		article.setPrix(prix);
		
		return article;
	}
	
	/**
	 * @return
	 */
	private Client creerClient() {
		
		String nom = ES.saisie("Nom: ");
		String prenom = ES.saisie("Prenom: ");
		String adresse = ES.saisie("Adresse: ");

		Client clt;
		
		clt = new Client();
		
		clt.setNom(nom);
		clt.setPrenom(prenom);
		clt.setAdresse(adresse);
		
		return clt;
	}
}
