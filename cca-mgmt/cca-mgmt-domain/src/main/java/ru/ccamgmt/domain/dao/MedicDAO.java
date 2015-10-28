package ru.ccamgmt.domain.dao;

import ru.ccamgmt.domain.entity.medic.Medic;
import ru.ccamgmt.domain.entity.section.Question;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Yuriy Stolyarenko on 28.10.2015.
 */
@Stateless
public class MedicDAO extends TemplateDAO<Medic> {

    @Override
    @SuppressWarnings("unchecked")
    public List<Medic> findAll() {
        return getEntityManager().createNamedQuery("Medic.getAllMedics", Medic.class).getResultList();
    }



}
