package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Aviso;
import service.AvisoService;

@ManagedBean(name="avisoBean")
@SessionScoped
public class AvisoBean {
	private List<Aviso> listadoAvisos = new ArrayList<Aviso>();
	private AvisoService objAviso = new AvisoService();
	
	private String titulo;
	private String describe;
	private String fechaPublicacion;
	private String selectedUser;
	private int idAviso;
	
	
	public String insertar(){
	AvisoService insert = new AvisoService();
	titulo = this.getDescribe().substring(0, 25);
	insert.insertar(titulo, describe);
	FacesContext contexto = FacesContext.getCurrentInstance();
	contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Se ha creado tu comentario!!!"));
	return "";
	}
	
	public List<Aviso> getAllAvisos()throws Exception{
		System.out.println("Llego al bean para invocar al servicio");
		listadoAvisos = objAviso.getAvisos();
		return listadoAvisos;
	}

	public List<Aviso> getListadoAvisos() {
		return listadoAvisos;
	}

	public void setListadoAvisos(List<Aviso> listadoAvisos) {
		this.listadoAvisos = listadoAvisos;
	}

	public int getIdAviso() {
		return idAviso;
	}

	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}

	public String getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
/******************************* End of Class.java *****************************************************/
