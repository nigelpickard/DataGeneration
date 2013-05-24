/**
 * 
 */
package com.npickard.data;

/**
 * @author nigel
 *
 */
public class Data2dInformation implements DataInformation {
	private String name;
	private final int NUM_COORDINATES = 2;

	public Data2dInformation(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "Name:" + name + ", Number of Coordinates: " + NUM_COORDINATES;
	}

}
