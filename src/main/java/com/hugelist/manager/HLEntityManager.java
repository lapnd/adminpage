package com.hugelist.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.impetus.client.cassandra.common.CassandraConstants;


public class HLEntityManager {
	private static final String PERSISTENCE_UNIT = "cassandra_hugelist";
	private  EntityManagerFactory emf = null;
	private  EntityManager em = null;
	private static HLEntityManager instance=null;
	
	public HLEntityManager(){
		emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);
		em = emf.createEntityManager();
	    em.setProperty(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);
	}
	public static HLEntityManager getInstance(){
		
		if (instance == null) {
			synchronized (HLEntityManager.class) {
				// Double check
				if (instance == null) {
					instance = new HLEntityManager();
				}
			}
		}
		return instance;
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
	
	public EntityManagerFactory getEntityManagerFactory(){
		return emf;
	}

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
    {
        this.emf = entityManagerFactory;
    }
	
}
