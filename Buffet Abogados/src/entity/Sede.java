package entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSede;

	private String direccion;

	private String estadoTabla;

	private String nombre;
	
	private String coordenadas;

	//bi-directional many-to-one association to Ciudad
	//@OneToMany(mappedBy="Ciudad")
	//private List<Ciudad> ciudades;

	//bi-directional many-to-one association to User
	//@OneToMany(mappedBy="user")
	//private List<User> users;

	public Sede() {
	}

	public int getIdSede() {
		return this.idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoTabla() {
		return this.estadoTabla;
	}

	public void setEstadoTabla(String estadoTabla) {
		this.estadoTabla = estadoTabla;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCoordenadas() {
		return this.coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
}