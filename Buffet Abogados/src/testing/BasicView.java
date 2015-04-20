package testing;

import service.AvisoService;
import testing.CarService;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.PostLoad;

import entity.Aviso;

@ManagedBean(name = "dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private List<Car> cars;
	private List<Aviso> avisos;

	private AvisoService service;

	// private CarService service;
	
	public void init() throws Exception {
		// cars = service.createCars(10);
		avisos = service.getAvisos();
	}

	// public List<Car> getCars() {
	// return cars;
	// }

	public List<Aviso> getAvisos() {
	return avisos;
	}

	public void setService(AvisoService service) {
		this.service = service;
	}
}