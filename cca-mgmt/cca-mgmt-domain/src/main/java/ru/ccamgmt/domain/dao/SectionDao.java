package ru.ccamgmt.domain.dao;

import ru.ccamgmt.domain.entity.medic.Medic;
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
public class SectionDAO extends TemplateDAO<Section> {

}
