package classes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ExecucaoPart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Estado estado = new Estado("Rio de Janeiro", "RJ");
		Aluno aluno = new Aluno("Vinicius", 25, estado);
		Aluno aluno2 = new Aluno("Fabiano", 25, estado);

		/* INSERINDO DADOS NO BD */
//		entityManager.getTransaction().begin();
//		entityManager.persist(estado);
//		entityManager.persist(aluno2);
//		entityManager.getTransaction().commit();

		/* BUSCANDO DADOS NO BD */
//		Estado estadoEncontrado = entityManager.find(Estado.class, 5);
//		Aluno alunoEncontrado = entityManager.find(Aluno.class, 4);
//		System.out.println(estadoEncontrado);
//		System.out.println(alunoEncontrado);

		/* ALTERANDO DADOS NO BD */
//		entityManager.getTransaction().begin();
//		alunoEncontrado.setIdade(21);
//		alunoEncontrado.setNome("Francisco");
//		alunoEncontrado.setEstado(estadoEncontrado);
//		entityManager.getTransaction().commit();

		/* REMOVENDO DADOS BD */
//		entityManager.getTransaction().begin();
//		entityManager.remove(estadoEncontrado);
//		entityManager.getTransaction().commit();

		/* Busca com SQL Nativo */
//		String nome = "Naruto";
//		String sql = "select * from aluno where nome = :nome";
//		Aluno alunoSQL = (Aluno) entityManager.createNativeQuery(sql, Aluno.class).setParameter("nome", nome)
//				.getSingleResult();
//		System.out.println(alunoSQL);
//		System.out.println();
//		String sqlString = "select * from aluno";
//		List<Aluno> list = entityManager.createNativeQuery(sqlString, Aluno.class).getResultList();
//		System.out.println("Lista de Alunos no BD:");
//		list.forEach(Aluno -> System.out.println(Aluno));

		/* Busca com JPQL */
//		String nome = "Naruto";
//		String jpql = "select a from Aluno a where a.nome = :nome";
//		Aluno alunoJQPL = entityManager.createQuery(jpql, Aluno.class).setParameter("nome", nome).getSingleResult();
//		System.out.println(alunoJQPL);
//		System.out.println();
//
//		String jpqlList = "select a from Aluno a";
//		List<Aluno> listAlunos = entityManager.createQuery(jpqlList, Aluno.class).getResultList();
//		System.out.println("Lista de Alunos no BD:");
//		listAlunos.forEach(Aluno -> System.out.println(Aluno));
//		System.out.println();
//		
//		// Trazendo todos alunos do RN
//		String jpqlList2 = "select a from Aluno a where a.estado.nome = :estadoNome";
//		List<Aluno> listAlunos2 = entityManager.createQuery(jpqlList2, Aluno.class)
//				.setParameter("estadoNome", "Rio Grande do Norte").getResultList();
//		System.out.println("Lista de Alunos do RN no BD:");
//		listAlunos2.forEach(Aluno -> System.out.println(Aluno));
//		System.out.println();
//		
//		// Trazendo todos alunos do RJ
//		String jpqlList3 = "select a from Aluno a where a.estado = :estado";
//		List<Aluno> listAlunos3 = entityManager.createQuery(jpqlList3, Aluno.class)
//				.setParameter("estado", entityManager.find(Estado.class,1)).getResultList();
//		System.out.println("Lista de Alunos do RJ no BD:");
//		listAlunos3.forEach(Aluno -> System.out.println(Aluno));
//		System.out.println();
		
		/* Busca com JPA Criteria API */
//		String nome = "Naruto";
//		CriteriaQuery<Aluno> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Aluno.class);
//		Root<Aluno> alunoRoot = criteriaQuery.from(Aluno.class);
//		CriteriaBuilder.In<String> inClause = entityManager.getCriteriaBuilder().in(alunoRoot.get(Aluno_.nome));
//		inClause.value(nome);
//		criteriaQuery.select(alunoRoot).where(inClause);
//		Aluno alunoAPICriteria = entityManager.createQuery(criteriaQuery).getSingleResult();
//		System.out.println(alunoAPICriteria);
		
		//Trazendo uma lista como resultado
		CriteriaQuery<Aluno> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Aluno.class);
		Root<Aluno> alunRootList  =criteriaQueryList.from(Aluno.class);
		List<Aluno> alunoAPICriteriaList = entityManager.createQuery(criteriaQueryList).getResultList();
		System.out.println("Lista de Alunos no BD:");
		alunoAPICriteriaList.forEach(Aluno -> System.out.println(Aluno));

		entityManager.close();
		entityManagerFactory.close();

	}

}
