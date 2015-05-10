package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Aviso;

public class AvisoService {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("buffet");
	EntityManager em = emf.createEntityManager();

	public AvisoService() {

	}

	private List<Aviso> listaAvisos = new ArrayList<Aviso>();

	// TO-DO improve jpa code.

	public void insertar(String titulo, String descripcion) {
		// This block is used for date generation then the JPA insertion
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		// so add 1 to make it inclusive
		String finalDate = dateFormat.format(date);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		Aviso aviso = new Aviso();
		System.out.println("estamos en Service, enviando titulo y descripcion "	+ titulo + " , " + descripcion);
		aviso.setTitulo(titulo);
		aviso.setDescripcion(descripcion);
		aviso.setFechaPublicacion(finalDate);
		aviso.setUser_idUser(2);
		em.persist(aviso);
		et.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Aviso> getAvisos() throws Exception {

		try {
			listaAvisos = em.createNamedQuery("Aviso.findAll", Aviso.class)
					.getResultList();
			System.out.println("Resultado de Query" + listaAvisos);

			return listaAvisos;

		} catch (Exception e) {
			return listaAvisos;
		}
	} // end of getAvisos

	public List<Aviso> getAvisosById(int userId) {

		try {
			listaAvisos = em.createNamedQuery("Aviso.findById", Aviso.class)
					.setParameter("userId", userId).getResultList();
			return listaAvisos;
		} catch (Exception e) {
			return listaAvisos;
		}
	}// End of getAvisosById
}// End of AvisoService Class
