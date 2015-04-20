package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserService {

	public String getUserName(String userIncome) {
		String userName;
		//JPA 
		//Instanciando objetos de JPA conexion BD
		EntityManagerFactory emf = null;
		EntityManager em = null;
		//
		System.out.println("Service class before creating entity manager.");
			emf = Persistence.createEntityManagerFactory("buffet");
			em = emf.createEntityManager();
			//consulta en la BD de la prueba en vista
			Query query = em.createQuery("select e.username from User e where e.username = '"+ userIncome + "'");
			System.out.println("query result"+query.getResultList().toString());
			
			//el query en el obj username una variable tipo string
			userName = query.getSingleResult().toString();
			System.out.println("username value just extracted "+userName);
			return userName;

	} //getUserName
	
	public String getPassword(String userIncome) {
		String password;
		//JPA 
		EntityManagerFactory emf = null;
		EntityManager em = null;

			emf = Persistence.createEntityManagerFactory("buffet");
			em = emf.createEntityManager();
			Query query = em.createQuery("select e.password from User e where e.username = '"+ userIncome + "'");
			System.out.println("Service class after creating entity manager.");
			System.out.println("query password value"+query.getSingleResult().toString());
			password = query.getSingleResult().toString();
			return password;

	} //getUserName
}
