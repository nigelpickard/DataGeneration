/**
 * 
 */
package com.npickard.app;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.npickard.data.Data1d;
import com.npickard.data.Data1dInformation;
import com.npickard.data.Data2d;
import com.npickard.data.Data2dInformation;
import com.npickard.data.Data3d;
import com.npickard.data.Data3dInformation;
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
		
		int sleepVal = 250;
		DataInformation dataInformation1 = new Data1dInformation("My first test data set");
		DataSet<Data1d> dataSet1 = new DataSet<Data1d>(dataInformation1);
		
		Random random = new Random();
		for (int count=0; count<10; count++){
			dataSet1.addData(new Data1d(new Date(), random.nextInt(100) ));
			try {
				Thread.sleep(sleepVal);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dataSet1.showData();
		
		
		DataInformation dataInformation2 = new Data2dInformation("My second test data set");
		DataSet<Data2d> dataSet2 = new DataSet<Data2d>(dataInformation2);
		
		for (int count=0; count<10; count++){
			dataSet2.addData(new Data2d(new Date(), random.nextInt(100), random.nextInt(100) ));
			try {
				Thread.sleep(sleepVal);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dataSet2.showData();
		
		DataInformation dataInformation3 = new Data3dInformation("My third test data set");
		DataSet<Data3d> dataSet3 = new DataSet<Data3d>(dataInformation3);
		
		for (int count=0; count<10; count++){
			dataSet3.addData(new Data3d(new Date(), random.nextInt(100), random.nextInt(100), random.nextInt(100) ));
			try {
				Thread.sleep(sleepVal);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dataSet3.showData();
	}
	
	
	
}
