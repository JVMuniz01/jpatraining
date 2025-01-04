package aplicacao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.pessoa;

public class programa {

	public static void main(String[] args) {
		pessoa p1 = new pessoa(null,"Carlos da Silva", "carlos@gmail.com");
		pessoa p2 = new pessoa(null,"Joao Pedro", "JPdelas@gmail.com");
		pessoa p3 = new pessoa(null,"Jose Lurdes", "lurdesjoseph@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		EntityManager em = emf.createEntityManager();
		
		pessoa p = em.find(pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		/*
		em.getTransaction().begin(); 
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		*/
		
		System.out.println("Pronto!");
		em.close();
		emf.close();

		

	}

}
