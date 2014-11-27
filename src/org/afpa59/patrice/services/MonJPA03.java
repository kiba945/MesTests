package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.utils.ES;

public class MonJPA03 {

	public void test() {
		Article article;
		int code;
		
		// Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Article");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();


		code = ES.saisie("*** SUPPRESSION ***\n"
				+ "Votre code Article:", 1, Integer.MAX_VALUE);

		article = em.find(Article.class, code);

		if (article == null) {
			ES.affiche("Article code " + code + " non trouvé");

		} else {
		/**********************************************************/
			String rep = ES.saisie("Voulez-vous supprimer l'article? (O/N)");

			if (rep.equals("o") || rep.equals("O")){
				
				em.remove(article);	
				
				ES.affiche("     ****** Votre Article ******\n"
						+ article.getCode()
						+ "\n     ****** a bien été supprimé ******");

				em.flush();	//Envoi sur la Base de donnée
				et.commit();	//Validation de l'envoi
				
			}
		/**********************************************************/

		}

		em.close();

	}


}
