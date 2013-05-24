package com.npickard.data;

import java.util.Date;

public class Data3d extends Data2d {
	
	protected final int z;
	
	public Data3d(Date generationDate, int x, int y, int z){
		super(generationDate, x, y);
		this.z = z;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data3d other = (Data3d) obj;
		if (z != other.z)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return super.toString() + (", z=" + z);
	}
}
