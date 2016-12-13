package ie.gmit.sw;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
public class Manufacturer {

	private String manuCode;
	private String manuName;
	private String manuDetails;
	private String updateCode;

	public Manufacturer(){
		
	}
	
	public Manufacturer(String manuCode, String manuName, String manuDetails) {
		this.manuCode = manuCode;
		this.manuName = manuName;
		this.manuDetails = manuDetails;
		
	}

	public String getUpdateCode() {
		return updateCode;
	}

	public void setUpdateCode(String updateCode) {
		this.updateCode = updateCode;
	}

	public String getManuCode() {
		return manuCode;
	}

	public void setManuCode(String manuCode) {
		this.manuCode = manuCode;
	}

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
	}

	public String getManuDetails() {
		return manuDetails;
	}

	public void setManuDetails(String manuDetails) {
		this.manuDetails = manuDetails;
	}
}
