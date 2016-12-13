package ie.gmit.sw;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class FullDetailsController {

	private Vehicle fullDetails;
	private DAO dao;
	private String updateReg = "XXX";

	public FullDetailsController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadFullDetails() throws Exception{
		setFullDetails(dao.getFullDetails(getUpdateReg()));
		System.out.println(fullDetails.getReg());
	}	


	public String getUpdateReg() {
		return updateReg;
	}

	public void setUpdateReg(String updateReg) {
		this.updateReg = updateReg;
	}


	public Vehicle getFullDetails() throws Exception {
		System.out.println("GET");
		return fullDetails;
	}


	public void setFullDetails(Vehicle fullDetails) {
		this.fullDetails = fullDetails;
	}
	
	public String fullDetailsClick()throws Exception {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		updateReg = params.get("reg");
		setUpdateReg(params.get("reg"));
		setFullDetails(dao.getFullDetails(getUpdateReg()));
		return "FullDetails";
	} 
}