package classes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecucaoPart1 {

	/*Esse código não roda, pois não foi especificada a implementação do JPA!*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Estado estado = new Estado("Rio de Janeiro", "RJ");
		Aluno aluno = new Aluno("Vinicius", 25, estado);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(estado);
		entityManager.persist(aluno);

		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
