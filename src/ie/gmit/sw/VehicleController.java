package ie.gmit.sw;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

@SessionScoped
@ManagedBean
public class VehicleController {

	private ArrayList<Vehicle> vehicle;
	private DAO dao;

	public VehicleController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Vehicle> getVehicle() {
		return vehicle;
	}

	public void loadVehicle() throws Exception {
		vehicle = dao.getVehicle();
	}

	public String addVehicle(Vehicle v) throws Exception {
		try {
			dao.addVehicle(v);
			return "Vehicle";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Error " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return e.toString();
		}
	}
	
	public Vehicle getFullDetails(Vehicle d) {
		return d;
	}
}
