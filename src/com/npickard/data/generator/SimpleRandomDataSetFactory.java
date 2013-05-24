package com.npickard.data.generator;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;

import com.npickard.data.DataSet;
import com.npickard.data.info.Data1dInformation;
import com.npickard.data.info.DataInformation;
import com.npickard.data.type.Data;
import com.npickard.data.type.Data1d;
import com.npickard.data.type.Data2d;
import com.npickard.data.type.Data3d;

public class SimpleRandomDataSetFactory implements DataGenerator{
	static Logger logger = Logger.getLogger(SimpleRandomDataSetFactory.class);
	private static final int DEFAULT_SLEEP_VAL = 1;
	private static final int DEFAULT_RANGE_TOP = 100;
	private static SimpleRandomDataSetFactory instance = null;
	
	private SimpleRandomDataSetFactory(){
	}
	
	/**
	 * 
	 * Gets a singleton instance. Note the use of lazy initialization
	 * and lack of the double checking.  This singleton could be 
	 * expensive to implement.
	 * 
	 * @return a SimpleSingleton
	 */
	public static synchronized SimpleRandomDataSetFactory getInstance(){
		if (instance==null){
			instance = new SimpleRandomDataSetFactory();
		}
		return instance;
	}

	@Override
	public DataSet generateDataSet(DataInformation dataInformation, int numData, Class clazz) throws Exception {
		if (Data1d.class.equals(clazz)){
			logger.info("Data set is 1d data");
			return generateData1dSet(dataInformation, numData);
		}else if (Data2d.class.equals(clazz)){
			logger.info("Data set is 2d data");
			return generateData2dSet(dataInformation, numData);
		}else if (Data3d.class.equals(clazz)){
			logger.info("Data set is 3d data");
			return generateData3dSet(dataInformation, numData);
		}else{
			logger.warn("Cannot find a type!");
			return null;
		}
	}
	

	private DataSet<Data1d> generateData1dSet(DataInformation dataInformation, int numData) throws Exception{
		return generateData1dSet(dataInformation, numData, DEFAULT_RANGE_TOP);
	}
		
	private DataSet<Data1d> generateData1dSet(DataInformation dataInformation, int numData, int rangeTop) throws Exception{
		DataSet<Data1d> dataSet = new DataSet<Data1d>(dataInformation);
		Random random = new Random();
		for (int count=0; count<numData; count++){
			dataSet.addData(new Data1d(new Date(), random.nextInt(rangeTop) ));
			try {
				Thread.sleep(DEFAULT_SLEEP_VAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dataSet;
	}

	private DataSet<Data2d> generateData2dSet(DataInformation dataInformation, int numData) throws Exception{
		return generateData2dSet(dataInformation, numData, DEFAULT_RANGE_TOP);
	}
		
	private DataSet<Data2d> generateData2dSet(DataInformation dataInformation, int numData, int rangeTop) throws Exception{
		DataSet<Data2d> dataSet = new DataSet<Data2d>(dataInformation);
		Random random = new Random();
		for (int count=0; count<numData; count++){
			dataSet.addData(new Data2d(new Date(), random.nextInt(rangeTop), random.nextInt(rangeTop) ));
			try {
				Thread.sleep(DEFAULT_SLEEP_VAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dataSet;
	}

	private DataSet<Data3d> generateData3dSet(DataInformation dataInformation, int numData) throws Exception{
		return generateData3dSet(dataInformation, numData, DEFAULT_RANGE_TOP);
	}
		
	private DataSet<Data3d> generateData3dSet(DataInformation dataInformation, int numData, int rangeTop) throws Exception{
		DataSet<Data3d> dataSet = new DataSet<Data3d>(dataInformation);
		Random random = new Random();
		for (int count=0; count<numData; count++){
			dataSet.addData(new Data3d(new Date(), random.nextInt(rangeTop), random.nextInt(rangeTop), random.nextInt(rangeTop) ));
			try {
				Thread.sleep(DEFAULT_SLEEP_VAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dataSet;
	}

}
