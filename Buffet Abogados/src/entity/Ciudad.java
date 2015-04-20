package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CiudadPK id;

	private String nombre;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="Pais_idPais")
	private Pai pai;

	public Ciudad() {
	}

	public CiudadPK getId() {
		return this.id;
	}

	public void setId(CiudadPK id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

}