package ru.ccamgmt.domain.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.ccamgmt.domain.exception.CcaMgmtPersistenceException;

import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Yuriy Stolyarenko on 25.10.2015.
 */
public class TemplateDAO<MODEL> implements ITemplateDAO<MODEL> {
//
//public abstract class BaseDAO<MODEL extends Identifiable> implements IBaseDAO<MODEL> {


    private static final String COUNT_QUERY_TMPL = "SELECT COUNT(ENTITY) FROM %s ENTITY";

    private static final String FIND_ALL_QUERY_TMPL = "SELECT ENTITY FROM %s ENTITY ORDER BY ENTITY.id ASC";

    @PersistenceContext
    private EntityManager entityManager;

    private Class<MODEL> persistentClass;

    private final String countQuery;

    private final String findAllQuery;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public TemplateDAO() {
        Class<?> superclass = getClass();
        while (superclass != null) {
            if (superclass.getGenericSuperclass() instanceof ParameterizedType) {
                Type modelType = ((ParameterizedType) superclass.getGenericSuperclass()).getActualTypeArguments()[0];
                this.persistentClass = (Class<MODEL>) modelType;
                break;
            }
            superclass = superclass.getSuperclass();
        }
        if (this.persistentClass == null) {
            throw new IllegalStateException("Can't determine model entity type!");
        }
        this.countQuery = String.format(COUNT_QUERY_TMPL, this.persistentClass.getSimpleName());
        this.findAllQuery = String.format(FIND_ALL_QUERY_TMPL, this.persistentClass.getSimpleName());
    }

    @Override
    public MODEL get(long id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MODEL> findAll() {
        // Query query = entityManager.createNamedQuery("getAll" + getEntityClass().getSimpleName());
        Query query = entityManager.createQuery(findAllQuery);
        return query.getResultList();
    }


    @Override
    public void persist(MODEL entity) throws CcaMgmtPersistenceException {
        if (entity != null) {
            try {
                entityManager.persist(entity);
                entityManager.flush();
            } catch (Exception e) {
                throw new CcaMgmtPersistenceException(e.getMessage(), e.getCause());
            }
        }
    }

    @Override
    public void delete(MODEL entity) throws CcaMgmtPersistenceException {
        if (entity != null) {
            try {
                entityManager.remove(entity);
                entityManager.flush();
            } catch (Exception e) {
                throw new CcaMgmtPersistenceException(e.getMessage(), e.getCause());
            }
        }
    }

    @Override
    public void delete(long id) throws CcaMgmtPersistenceException {
        try {
            MODEL entity = entityManager.find(getEntityClass(), id);
            entityManager.remove(entity);
            entityManager.flush();
        } catch (Exception e) {
            throw new CcaMgmtPersistenceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void deleteAll() throws CcaMgmtPersistenceException {
        try {
            List<MODEL> entities = findAll();
            for (MODEL entity : entities) {
                entityManager.remove(entity);
            }
            entityManager.flush();
        } catch (Exception e) {
            throw new CcaMgmtPersistenceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public long count() {
        Query query = entityManager.createQuery(this.countQuery);
        return (Long) query.getSingleResult();
    }

    @Override
    public MODEL merge(MODEL entity) throws CcaMgmtPersistenceException {
        if (entity != null) {
            try {
                return entityManager.merge(entity);
            } catch (Exception e) {
                throw new CcaMgmtPersistenceException(e.getMessage(), e.getCause());
            }
        }
        return null;
    }

    @Override
    public Query getNamedQuery(String queryName) {
        return entityManager.createNamedQuery(queryName);
    }

    @Override
    public void refresh(MODEL entity) {
        entityManager.refresh(entity);
    }

    /**
     * Get entity class
     *
     * @return Managed entity class
     */
    protected Class<MODEL> getEntityClass() {
        return persistentClass;
    }

}
