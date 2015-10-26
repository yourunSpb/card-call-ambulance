package ru.ccamgmt.domain.dao;

import ru.ccamgmt.domain.exception.CcaMgmtPersistenceException;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Yuriy Stolyarenko on 25.10.2015.
 */
public interface ITemplateDAO<MODEL> {

    /**
     * entity manager
     * @return <code>EntityManager</code> object
     */
    EntityManager getEntityManager();

    /**
     * object from table by id
     * @param id found object id
     * @return object or <code>null</code> if there is no object with specified id
     * in table
     */
    MODEL get(long id);

    /**
     * all existed objects
     * @return list of objects
     */
    List<MODEL> findAll();

    /**
     * Persist entity
     * @param entity entity
     * @throws CcaMgmtPersistenceException if something goes wrong
     */
    void persist(MODEL entity) throws CcaMgmtPersistenceException;

    /**
     * Merges entity with table record
     * @param entity object to be merged
     * @return merged entity
     * @throws CcaMgmtPersistenceException if something goes wrong
     */
    MODEL merge(MODEL entity) throws CcaMgmtPersistenceException;

    /**
     * Deletes record from table
     * @param entity object to be deleted
     * @throws CcaMgmtPersistenceException if something goes wrong
     */
    void delete(MODEL entity) throws CcaMgmtPersistenceException;

    /**
     * Deletes record from table by id
     * @param id id of object to be deleted
     * @throws CcaMgmtPersistenceException if something goes wrong
     */
    void delete(long id) throws CcaMgmtPersistenceException;

    /**
     * Deletes all records from table
     * @throws CcaMgmtPersistenceException if something goes wrong
     */
    void deleteAll() throws CcaMgmtPersistenceException;

    /**
     * Count total amount of entities
     * @return total count
     */
    long count();

    /**
     * Refresh entity from database
     * @param entity object to be refreshed
     */
    void refresh(MODEL entity);

    /**
     * Get named query by name
     * @param queryName query name
     * @return query name or exception if query with such name doesn't exist
     */
    Query getNamedQuery(String queryName);
}

