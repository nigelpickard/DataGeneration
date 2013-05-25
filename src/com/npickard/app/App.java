/**
 * 
 */
package com.npickard.app;

import java.util.SortedSet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.npickard.data.DataSet;
import com.npickard.data.generator.SimpleRandomDataSetFactory;
import com.npickard.data.info.Data1dInformation;
import com.npickard.data.info.Data2dInformation;
import com.npickard.data.info.Data3dInformation;
import com.npickard.data.type.Data;
import com.npickard.data.type.Data1d;
import com.npickard.data.type.Data2d;
import com.npickard.data.type.Data3d;
import com.npickard.persistence.PersistenceManager;



/**
 * @author nigel
 *
 */
public class App {
	// Define a static logger variable so that it references the
	// Logger instance named "App".
	static Logger logger = Logger.getLogger(App.class);

	static{
	// Set up a simple configuration that logs on the console.
		BasicConfigurator.configure();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("Data Generation application is started.");
		
		DataSet<? extends Data> dataSet1d = null;
		try {
			dataSet1d = SimpleRandomDataSetFactory.getInstance().generateDataSet(new Data1dInformation("New 1d data"), 10, Data1d.class);
			dataSet1d.showData();
			//persist dataset
			SortedSet<? extends Data> dataset = dataSet1d.getDataSet();
			for (Data data :  dataset){
				PersistenceManager.getInstance().saveData(data);
			}
			
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}

		DataSet<? extends Data> dataSet2d = null;
		try {
			dataSet2d = SimpleRandomDataSetFactory.getInstance().generateDataSet(new Data2dInformation("New 2d data"), 10, Data2d.class);
			dataSet2d.showData();

			//persist dataset
			SortedSet<? extends Data> dataset = dataSet2d.getDataSet();
			for (Data data :  dataset){
				PersistenceManager.getInstance().saveData(data);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		
		
		DataSet<? extends Data> dataSet3d = null;
		try {
			dataSet3d = SimpleRandomDataSetFactory.getInstance().generateDataSet(new Data3dInformation("New 3d data"), 10, Data3d.class);
			dataSet3d.showData();

			//persist dataset
			SortedSet<? extends Data> dataset = dataSet3d.getDataSet();
			for (Data data :  dataset){
				PersistenceManager.getInstance().saveData(data);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}

	}
	
	
	
}
