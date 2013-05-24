package com.npickard.data.type;

import java.util.Date;


public class Data1d extends Data {

	protected final int x;
	
	public Data1d(Date generationDate, int x){
		super(generationDate);
		this.x = x;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + x;
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
		Data1d other = (Data1d) obj;
		if (x != other.x)
			return false;
		return true;
	}


	@Override
	public String toString(){
		return super.toString() + (", x=" + x);
	}

}
