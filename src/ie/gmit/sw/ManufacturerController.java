package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean
public class ManufacturerController {

	private ArrayList<Manufacturer> manufacturer = new ArrayList<>();
	private DAO dao;
	private String updateCode = "XXX";
	private String updateName = "empty";
	private String updateDetails = "empty";
	
	public String getUpdateCode(){
		return updateCode;
	}
	public void setUpdateCode(String updateCode){
		this.updateCode = updateCode;
	}

	public ManufacturerController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Manufacturer> getManufacturer() {
		return manufacturer;
	}

	public void loadManufacturers() throws Exception {
		manufacturer = dao.getManufacturer();
	}

	public String addManufacturer(Manufacturer m) throws Exception {
		try {
			dao.addManufacturer(m);
			return "Manufacturers";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String updateManufacturerClick() throws Exception{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String, String> params = externalContext.getRequestParameterMap();
		updateCode = params.get("manuCode");
		updateName = params.get("manuName");
		updateDetails = params.get("manuDetails");
		return "UpdateManufacturer";
	}
	
	public String updateManufacturer(Manufacturer m) throws Exception {
		try {
			m.setManuCode(updateCode);
			m.setManuName(updateName);
			m.setManuDetails(updateDetails);
			dao.updateManufacturer(m);
			return "UpdateManufacturer";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Error " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			String error = "Error: " + e + "\nCould not update Manufacturer";
			System.out.println(error);
			return error;
		}
	}

	public String deleteManufacturer(Manufacturer m) throws Exception {

		try {
			dao.deleteManufacturer(m);
			return "Manufacturers";
		} catch (Exception e) {
			return e.toString();
		}
	}
	public String getUpdateName() {
		return updateName;
	}
	
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	
	public String getUpdateDetails() {
		return updateDetails;
	}
	
	public void setUpdateDetails(String updateDetails) {
		this.updateDetails = updateDetails;
	}
	
}
	