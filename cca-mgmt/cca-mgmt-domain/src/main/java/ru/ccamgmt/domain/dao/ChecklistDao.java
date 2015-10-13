package ru.ccamgmt.domain.dao;

import ru.ccamgmt.domain.entity.Checklist;
import ru.ccamgmt.domain.entity.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Владимир on 13.10.2015.
 */
@Stateless
public class ChecklistDao {

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Return {@link ru.ccamgmt.domain.entity.Checklist} instance with specified ID.
     *
     * @param checklistId ID of item to find.
     * @return {@link Checklist} with specified ID; null otherwise.
     */
    public Checklist findById(long checklistId) {
        return entityManager.find(Checklist.class, checklistId);
    }

    /**
     * Persists checklist and returns new checklist id
     *
     * @param checklist entity to persist
     * @return persisted checklist id
     */
    public Long persist(Checklist checklist) {
        entityManager.persist(checklist);
        entityManager.flush();
        entityManager.refresh(checklist);
        return checklist.getId();
    }

    /**
     * Merges passed data with data existing in database.
     *
     * @param checklist item to be merged to database.
     */
    public void update(Checklist checklist) {
        entityManager.merge(checklist);
        entityManager.flush();
    }

    //TODO example use NamedQuery
    public List<Question> findItemByHashSum(Long checklistId) {
        return entityManager.createNamedQuery("Checklist.getQuestion", Question.class).setParameter("checklistId", checklistId).getResultList();
    }
}
