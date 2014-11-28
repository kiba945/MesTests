package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.donnees.Commande;
import org.afpa59.patrice.donnees.LigneDeCommande;
import org.afpa59.patrice.utils.ES;

public class MonJPA08 {

	public void test() {
		// TODO Auto-generated method stub


		// Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		/*********************CLIENT************************/				
		Client clt = creer();

		em.persist(clt);
		/**************************************************/

		Commande cde = new Commande();

		/****************LigneCOMMANDE***************************/	
		LigneDeCommande ldc = new LigneDeCommande();
		
		ldc.setQuantite(15);

		/**************************************************/
		
		/****************COMMANDE***************************/	

		cde.setCodeCde("ZTEZR1565");
		cde.setMontantCommande(10000);
		
		cde.ajouter(ldc);

		cde.setClt(clt);

		em.persist(cde);
		/**************************************************/			
		
		
		em.flush();	//Envoi sur la Base de donnée
		et.commit();	//Validation de l'envoi

		em.close();
		emf.close();

		ES.affiche("     ****** Votre Client ******\n"
				+ clt.toString()
				+ "\n     ****** a bien été crée ******"
				+ "\n\n    ****** Votre Commande ****\n"
				+ cde.toString()
				+ "");

	}

	private Client creer() {
		// TODO Auto-generated method stub
		String nom;
		String prenom;
		String adresse;

		Client clt;

		clt = new Client();

		nom = ES.saisie("Nom: ");
		prenom = ES.saisie("Prenom: ");
		adresse = ES.saisie("adresse: ");

		clt.setNom(nom);
		clt.setPrenom(prenom);
		clt.setAdresse(adresse);


		return clt;
	}

}
