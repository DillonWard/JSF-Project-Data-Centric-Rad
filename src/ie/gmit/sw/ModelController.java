package ie.gmit.sw;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.event.ComponentSystemEvent;
import javax.faces.context.FacesContext;

@ManagedBean
public class ModelController {


	private ArrayList<Model> model = new ArrayList<>();
	private DAO dao;

	public ModelController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Model> getModel() {
		return model;
	}

	public void loadModel() throws Exception {
		model = dao.getModel();
	}	
	
	public String addModel(Model md) throws Exception {
		try {
			dao.addModel(md);
			return "Model";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Error " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return e.toString();
		}

	}
	
}
