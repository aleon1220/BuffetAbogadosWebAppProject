package bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.jpa.config.sequencing.GeneratedValueImpl;
import org.eclipse.persistence.internal.jpa.deployment.xml.parser.PersistenceContentHandler;

import entity.Aviso;
import service.AvisoService;

@ManagedBean(name = "avisoBean")
@SessionScoped
public class AvisoBean {

	public AvisoBean() {

	}

	private int idAviso;
	private String titulo;
	private String descripcion;
	private String fechaPublicacion;

	public String createAviso() {

		/* This block is used for date generation then the JPA insertion */
		String validation;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		// Usually this can be a field rather than a method variable
		Random rand = new Random();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((15 - 1) + 1) + 1;
		System.out.println(dateFormat.format(date));
		String FinalDate = dateFormat.format(date);

		Aviso aviso = new Aviso();
		//aviso.setIdAviso(randomNum);
		//System.out.println("Id Aviso Set: " + aviso.getIdAviso());
		aviso.setTitulo(this.getDescripcion());
		System.out.println("Titulo Aviso: " + this.getTitulo());
		aviso.setDescripcion(this.getDescripcion());
		System.out.println("Descripcion Aviso: " + this.getDescripcion());
		aviso.setFechaPublicacion(FinalDate);
		System.out.println("Fecha Aviso: " + FinalDate);

		try {
			System.out.println("AvisoBean--> inside try");
			AvisoService avisoService = new AvisoService();
			validation = avisoService.addAviso(aviso);
			System.out.println("value of validation " + validation);

			if (validation.equals("success")) {
				return "publicaAvisoSucess";
			} else {
				return "publicaAvisoError";
			}
		}// End of Try block
		catch (Exception e) {
			System.out.println("failure at " + e.getLocalizedMessage());
			return "publicaAvisoError";
		}

	} // end of method addAviso();

	public String obtainAvisoByUser() {

		/* This block is used for date generation then the JPA insertion */
		String validation;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		// Usually this can be a field rather than a method variable
		Random rand = new Random();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((15 - 1) + 1) + 1;
		System.out.println(dateFormat.format(date));
		String FinalDate = dateFormat.format(date);

		String toValidate = "sucess";

		Aviso aviso = new Aviso();
		aviso.setIdAviso(randomNum);
		System.out.println("Id Aviso Set: " + aviso.getIdAviso());
		aviso.setTitulo(this.getDescripcion());
		System.out.println("Titulo Aviso: " + this.getTitulo());
		aviso.setDescripcion(this.getDescripcion());
		System.out.println("Descripcion Aviso: " + this.getDescripcion());
		aviso.setFechaPublicacion(FinalDate);
		System.out.println("Fecha Aviso: " + FinalDate);

		try {
			System.out.println("AvisoBean--> inside try");
			AvisoService avisoService = new AvisoService();
			validation = avisoService.addAviso(aviso);
			System.out.println("value of validation " + validation);

			if (validation.equals("success")) {
				return "publicaAvisoSucess";
			} else {
				return "publicaAvisoError";
			}
		}// End of Try block
		catch (Exception e) {
			System.out.println("failure at " + e.getLocalizedMessage());
			return "publicaAvisoError";
		}

	} // end of method obtainAvisoByUser();

	
	public int getIdAviso() {
		return idAviso;
	}

	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

}
/******************************* End of Class.java *****************************************************/
