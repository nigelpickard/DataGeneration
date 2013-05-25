/**
 * 
 */
package com.npickard.data.type;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author nigel
 *
 */
public class Data implements Comparable<Data>{
	static Logger logger = Logger.getLogger(Data.class);
	private Long id;
	protected Date generationDate;
	
	public Data(){
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Data(Date generationDate){
		this.generationDate = generationDate;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((generationDate == null) ? 0 : generationDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (generationDate == null) {
			if (other.generationDate != null)
				return false;
		} else if (!generationDate.equals(other.generationDate))
			return false;
		return true;
	}

	@Override
	public int compareTo(Data o) {
		return this.generationDate.compareTo(o.getGenerationDate());
	}
	
	@Override
	public String toString(){
		return ("Generation date:" + generationDate.getTime());
	}
	
}
