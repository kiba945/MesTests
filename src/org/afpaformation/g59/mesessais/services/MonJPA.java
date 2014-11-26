package org.afpaformation.g59.mesessais.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpaformation.g59.mesessais.donnees.Article;
import org.afpaformation.g59.mesessais.utils.ES;

public class MonJPA {
	
	public void test() {
		// TODO Auto-generated method stub
		
		
	    // Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
		
		
		
		EntityManager em = emf.createEntityManager();
				
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Article article = CreerArticle();	
		
		
		ES.affiche("     ****** Votre Article ******\n"
		+ article.toString()
		+ "\n     ****** a bien été crée ******");
		

		em.persist(article);
		
		em.merge(article);
//		em.flush();	//Envoi sur la Base de donnée
		et.commit();	//Validation de l'envoi

		/**********************************************************/
		String rep = ES.saisie("Voulez-vous supprimer l'article? (O/N)");
		
		if (rep.equals("o") || rep.equals("O")){
			
			Article article2 = CreerArticle();
			
			em.merge(article2);
			
			em.remove(article);
//			em.flush();	//Envoi sur la Base de donnée
			et.commit();	//Validation de l'envoi
			
		}
		/**********************************************************/
		
//		String MySelect;
//		
//		MySelect = "SELECT "
//				+ "* "
//				+ "FROM "
//				+ "Article;";
//		
//		em.createQuery(MySelect);	
		
		
//		em.flush();	//Envoi sur la Base de donnée
//		et.commit();	//Validation de l'envoi
		
		
		em.close();
		
	}

	/**
	 * @return
	 */
	private Article CreerArticle() {
		
		int code = ES.saisie("Votre code Article:", 1, Integer.MAX_VALUE);
		String designation = ES.saisie("Votre désignation Article:");
		Float prix = ES.saisie("Votre prix Article", 1, Float.MAX_VALUE);
		
		Article article;
		
		article = new Article();
		
		article.setCode(code);
		article.setDesignation(designation);
		article.setPrix(prix);
		
		return article;
	}
}
