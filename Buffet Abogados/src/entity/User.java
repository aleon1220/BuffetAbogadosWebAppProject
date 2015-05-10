package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pais database table.
 * 
 */

@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;
	private String email;
	private String password;
	private int sede_IdSede;
	private String username;

	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSede_IdSede() {
		return sede_IdSede;
	}
	public void setSede_IdSede(int sede_IdSede) {
		this.sede_IdSede = sede_IdSede;
	}
}