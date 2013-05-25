package com.npickard.persistence;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.npickard.data.DataSet;
import com.npickard.data.type.Data;
import com.npickard.hibernate.util.HibernateUtil;

public class PersistenceManager{
	static Logger logger = Logger.getLogger(PersistenceManager.class);
	private static PersistenceManager instance = null;
	
	private PersistenceManager(){
	}
	
	/**
	 * 
	 * Gets a singleton instance. Note the use of lazy initialization
	 * and lack of the double checking.  This singleton could be 
	 * expensive to implement.
	 * 
	 * @return a SimpleSingleton
	 */
	public static synchronized PersistenceManager getInstance(){
		if (instance==null){
			instance = new PersistenceManager();
		}
		return instance;
	}

	public void saveDataSet(DataSet<? extends Data> dataSet) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(dataSet);
        session.getTransaction().commit();	
	}
	
	public void saveData(Data data) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(data);
        session.getTransaction().commit();	
	}

}
