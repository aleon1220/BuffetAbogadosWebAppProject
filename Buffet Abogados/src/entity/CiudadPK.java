package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ciudad database table.
 * 
 */
@Embeddable
public class CiudadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idCiudad;

	@Column(insertable=false, updatable=false)
	private int pais_idPais;

	public CiudadPK() {
	}
	public int getIdCiudad() {
		return this.idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public int getPais_idPais() {
		return this.pais_idPais;
	}
	public void setPais_idPais(int pais_idPais) {
		this.pais_idPais = pais_idPais;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CiudadPK)) {
			return false;
		}
		CiudadPK castOther = (CiudadPK)other;
		return 
			(this.idCiudad == castOther.idCiudad)
			&& (this.pais_idPais == castOther.pais_idPais);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCiudad;
		hash = hash * prime + this.pais_idPais;
		
		return hash;
	}
}