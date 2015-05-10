package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the aviso database table.
 * 
 */

@Entity
@Table(name="aviso")
@NamedQueries({
	@NamedQuery(name= "Aviso.findAll", query="SELECT a FROM Aviso a"),
	@NamedQuery(name= "Aviso.findAvisos", query="SELECT a.titulo, a.descripcion, a.fechaPublicacion, u.username userName FROM Aviso a, User u WHERE a.user_idUser=u.idUser order by u.username"),
	@NamedQuery(name="Aviso.findById", query="SELECT a FROM Aviso a WHERE a.user_idUser= :userId")
})

public class Aviso {
	
	@Id
	@Column(name="idAviso")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int idAviso;
	String titulo;
    String descripcion;
	String fechaPublicacion;

	@Column(name="user_idUser")
	int user_idUser;
	

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

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

}