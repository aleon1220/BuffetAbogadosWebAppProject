package bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import service.UserService;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {

	public UserBean() {
	}

	String output_page;
	private Date createdTime;
	private String email;
	private String password;
	private String username;
	private String returnMsg;

	// Metodo para hacer login.
	public String login() {

		try {
			UserService userService = new UserService();
			System.out.println("Entre al try de USerBean, testing input and extracted variables.....");
			
			String usernameComparar = userService.getUserName(username).toLowerCase();
			String passwordComprar = userService.getPassword(username).toLowerCase();
			
			System.out.println("User from view = "+ this.getUsername());
			System.out.println("User from DB = "+ usernameComparar);
			System.out.println("Pass from view = "+ this.getPassword());
			System.out.println("Pass from DB = "+ passwordComprar);

			boolean test1 = this.getUsername().equals(usernameComparar.toString().toLowerCase());
			boolean test2 = this.getPassword().equals(passwordComprar.toString().toLowerCase());
			boolean test3 = username == usernameComparar;
			boolean test4 = password == passwordComprar;
			System.out.println("assertion1 " + test1);
			System.out.println("assertion2 " + test2);
			System.out.println("assertion3 " + test3);
			System.out.println("assertion4 " + test4);

			if (this.getUsername().equals(usernameComparar.toString()) && this.getPassword().equals(passwordComprar.toString())) {
				System.out.println("Inside Good If");
				output_page = "index";
				return output_page;
			} else if (username.equals("") && password.equals("")) {
				System.out.println("Inside bad error else 2");
				output_page = "errorLogin";
				return output_page;
			} else {
				System.out.println("Inside bad error else");
				output_page = "errorLogin";
			}
			System.out.println("value of output_page in return" + output_page);
			return output_page;
		} catch (Exception e) {
			this.setReturnMsg(e.getMessage());
			e.printStackTrace();
			System.out.println("inside exception catch.");
			return "failure";
		}
	}// end of method

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
}
