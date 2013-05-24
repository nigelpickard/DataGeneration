package com.npickard.data;

import java.util.Date;

public class Data2d extends Data {

	protected final int x;
	protected final int y;
	
	public Data2d(Date generationDate, int x, int y){
		super(generationDate);
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + x;
		result = prime * result + y;
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
		Data2d other = (Data2d) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString(){
		return super.toString() + (", x=" + x + ", y=" + y);
	}

}
