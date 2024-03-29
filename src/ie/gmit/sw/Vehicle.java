package ie.gmit.sw;

public class Vehicle {

	private String reg;
	private String manuCode;
	private String manuName;
	private String manuDetails;
	private String modelCode;
	private String modelName;
	private String modelDesc;
	private int mileage;
	private double price;
	private String colour;
	private String fuel;

	public Vehicle(String reg, String manuCode, String modelCode, int mileage, double price, String colour,
			String fuel) {
		super();
		this.reg = reg;
		this.manuCode = manuCode;
		this.modelCode = modelCode;
		this.mileage = mileage;
		this.price = price;
		this.colour = colour;
		this.fuel = fuel;
	}	

	public Vehicle (String reg, String manuCode, String manuName, String manuDetails, String modelCode, String modelName,
			String modelDesc, int mileage, double price, String colour, String fuel) {
		super();
		this.reg = reg;
		this.manuCode = manuCode;
		this.manuName = manuName;
		this.manuDetails = manuDetails;
		this.modelCode = modelCode;
		this.modelName = modelName;
		this.modelDesc = modelDesc;
		this.mileage = mileage;
		this.price = price;
		this.colour = colour;
		this.fuel = fuel;
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

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelDesc() {
		return modelDesc;
	}

	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getManuCode() {
		return manuCode;
	}

	public void setManuCode(String manuCode) {
		this.manuCode = manuCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
}