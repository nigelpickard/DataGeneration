/**
 * 
 */
package com.npickard.data;

import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**
 * @author nigel
 *
 */
public class DataSet<T extends Data> {
	static Logger logger = Logger.getLogger(DataSet.class);

	private final DataInformation dataInformation;
	/*
	 * I want a collection of data objects, where each object will
	 * be unique and not null, and the collection is sorted by generation 
	 * date.  We do not want to use an order as perhaps we cannot 
	 * guarantee data will be placed into the collection in time sequence.
	 * 
	 * To fulfill this requirement, we will use a set (no nulls or duplicates)
	 * and use the SortedSet to sort the elements by date
	 * 
	 */
	private final SortedSet<T> dataSet = new TreeSet<T>(); 
	
	public DataSet(DataInformation dataInformation){
		this.dataInformation = dataInformation;
	}
	
	public DataInformation getDataInformation() {
		return dataInformation;
	}

	public SortedSet<T> getDataSet() {
		return dataSet;
	}

	/**
	 * adds a data object to the data set.
	 * @param data
	 */
	public void addData(T data){
		if (dataSet.contains(data)){
			logger.warn("Unable to add data " +  data.toString() + " to dataset; it is already in the dataset.");
		}else{
			dataSet.add(data);
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataInformation == null) ? 0 : dataInformation.hashCode());
		result = prime * result + ((dataSet == null) ? 0 : dataSet.hashCode());
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
		DataSet other = (DataSet) obj;
		if (dataInformation == null) {
			if (other.dataInformation != null)
				return false;
		} else if (!dataInformation.equals(other.dataInformation))
			return false;
		if (dataSet == null) {
			if (other.dataSet != null)
				return false;
		} else if (!dataSet.equals(other.dataSet))
			return false;
		return true;
	}

	public void showData(){
		if (dataSet==null ||  dataSet.size() <1){
			logger.warn("Data set is null or empty.");
		}else{
			logger.info(dataInformation.toString());
			logger.info("Number of data in dataset is " + dataSet.size());
			for (T data : dataSet){
				logger.info(data.toString());
			}
		}
	}
}
