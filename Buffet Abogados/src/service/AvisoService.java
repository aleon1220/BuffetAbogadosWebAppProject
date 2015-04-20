package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Aviso;

public class AvisoService {

	public String addAviso(Aviso aviso) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		emf = Persistence.createEntityManagerFactory("buffet");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		System.out.println("before inserting record, getting info: descripcion "+aviso.getDescripcion()+aviso.getTitulo());
		em.persist(aviso);
		et.commit();
		return "sucess";
	} // end of addCaso
	
	public List<Aviso> getAvisos() throws Exception{
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		List<Aviso> avisosList = null;

		emf = Persistence.createEntityManagerFactory("buffet");
		em = emf.createEntityManager();
		//consulta en la BD de la prueba en vista
		Query query = em.createQuery("select e.idAviso, e.titulo, e.descripcion, e.fechapublicacion from Aviso e");
		System.out.println("query result"+query.getResultList().toString());
		avisosList = (List)query.getResultList();
		
		if(avisosList.size() == 0){
			throw new Exception("No existen Avisos");
		}
		
		return avisosList;
	} // end of addCaso
	
}
