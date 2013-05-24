/**
 * 
 */
package com.npickard.app;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.npickard.data.Data;
import com.npickard.data.Data2d;
import com.npickard.data.Data2dInformation;
import com.npickard.data.DataInformation;
import com.npickard.data.DataSet;



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
		DataInformation dataInformation = new Data2dInformation("My test data set");
		DataSet dataSet = new DataSet(dataInformation);
		
		Random random = new Random();
		Data data = null;
		for (int count=0; count<10; count++){
			data = new Data2d(new Date(), random.nextInt(100), random.nextInt(100) );
			dataSet.addData(data);
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		dataSet.showData();
	}
	
	
	
}
