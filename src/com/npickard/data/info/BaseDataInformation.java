package com.npickard.data.info;

public class BaseDataInformation implements DataInformation{
	protected String name;
	protected int NUM_COORDINATES;
	
	public BaseDataInformation(String name){
		this.name = name;
	}
	
	@Override	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int getNumCoordinates() {
		return NUM_COORDINATES;
	}
	
	@Override
	public String toString(){
		return "Name:" + name + ", Number of Coordinates: " + NUM_COORDINATES;
	}

}
