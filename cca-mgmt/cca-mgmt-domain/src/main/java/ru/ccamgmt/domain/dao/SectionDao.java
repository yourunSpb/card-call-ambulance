package ru.ccamgmt.domain.dao;

import ru.ccamgmt.domain.entity.section.Section;
import ru.ccamgmt.domain.entity.section.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yuriy Stolyarenko on 13.10.2015.
 */
@Stateless
public class SectionDAO {

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Return {@link Section} instance with specified ID.
     *
     * @param sectionId ID of item to find.
     * @return {@link Section} with specified ID; null otherwise.
     */
    public Section findById(long sectionId) {
        return entityManager.find(Section.class, sectionId);
    }

    /**
     * Persists section and returns new section id
     *
     * @param section entity to persist
     * @return persisted section id
     */
    public Long persist(Section section) {
        entityManager.persist(section);
        entityManager.flush();
        entityManager.refresh(section);
        return section.getId();
    }

    /**
     * Merges passed data with data existing in database.
     *
     * @param section item to be merged to database.
     */
    public void update(Section section) {
        entityManager.merge(section);
        entityManager.flush();
    }

    //TODO example use NamedQuery
    public List<Question> findItemByHashSum(Long sectionId) {
        return entityManager.createNamedQuery("Section.getQuestion", Question.class).setParameter("sectionId", sectionId).getResultList();
    }
}
