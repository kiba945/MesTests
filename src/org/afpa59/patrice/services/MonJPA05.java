package org.afpa59.patrice.services;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.utils.ES;

public class MonJPA05 {

	public void test() {
		// TODO Auto-generated method stub
		 // Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Article");
		
		EntityManager em = emf.createEntityManager();
				
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		String mySelect;
		mySelect = "SELECT a"
				+ " FROM "
				+ "Article as a";
		
		
		Query maRequete = em.createQuery(mySelect);
		
		
		List results = maRequete.getResultList();
		Iterator it = results.iterator();
		
		String st = "";
		while (it.hasNext()){
			Article a = (Article) it.next();
			st = st + "****" + a + "\n";
		}
		
		ES.affiche(st);
				
	}

}
