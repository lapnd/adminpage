package com.hugelist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.impetus.client.cassandra.common.CassandraConstants;

@Repository("hugeListDao")
public class HugeListDaoImpl implements HugeListDao {
	
	private static final Logger log = LoggerFactory.getLogger(HugeListDaoImpl.class);
	private static final String PERSISTENCE_UNIT = "cassandra_hugelist";
	private  EntityManagerFactory emf;
	private  EntityManager em;
	
	{
		emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);
		em = emf.createEntityManager();
	    em.setProperty(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);
	}
	
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
    public void insert(Object entity)
    {
		em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public void update(Object entity)
    {
    	em.getTransaction().begin();
        em.merge(entity);
        em.flush();
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public void remove(Object entity)
    {
    	em.getTransaction().begin();
        em.remove(entity);
        em.flush();
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public <T> T findById(Class<T> entityClazz, Object id)
    {
    	em.clear();
        T results = em.find(entityClazz, id);
      
        return results;
    }

    @Override
    public List<?> findByQuery(String queryString)
    {
    	
    	em.clear();
        Query query = em.createQuery(queryString);
        List<?> resultList = query.getResultList();
        
        return resultList;
    }

    @Override
    public List<?> findByQuery(String queryString, String paramater, Object parameterValue)
    {
    	em.clear();
        Query query = em.createQuery(queryString);
        query.setParameter(paramater, parameterValue);
        log.info(queryString);
        List<?> resultList = query.getResultList();
        
        return resultList;
    }

    

    @Override
    public void closeEntityManager()
    {
        if (em != null)
        {
            em.close();
        }
    }

    @Override
    public void clearEntityManager()
    {
        if (em != null)
        {
            em.clear();
        }
    }

    @Override
    public void shutDown()
    {
        if (em != null)
        {
            em.close();
        }
    }

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
}
