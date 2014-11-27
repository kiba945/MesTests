package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.utils.ES;

public class MonJPA08 {

	public void test() {
		// TODO Auto-generated method stub
		
		
	    // Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");
		
		EntityManager em = emf.createEntityManager();
				
		EntityTransaction et = em.getTransaction();
		
		et.begin();
				
		Client clt = creer();
			
		em.persist(clt);
	
		em.flush();	//Envoi sur la Base de donnée
		et.commit();	//Validation de l'envoi
		
		em.close();
		emf.close();
		
		ES.affiche("     ****** Votre Article ******\n"
		+ clt.toString()
		+ "\n     ****** a bien été crée ******");
		
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
