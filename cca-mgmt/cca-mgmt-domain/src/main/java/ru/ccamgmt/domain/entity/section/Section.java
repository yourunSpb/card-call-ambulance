package ru.ccamgmt.domain.entity.section;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import ru.ccamgmt.domain.entity.ServiceCoreConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 13.10.2015.
 */
@Entity
@Table(name = "SECTION")
@SequenceGenerator(name = "SECTION_ID_SEQ", sequenceName = "SEQ_SECTION_ID")
public class Section implements Serializable {

    private static final long serialVersionUID = -2540435326860743350L;

    @Id
    @Column(name = "SECTION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECTION_ID_SEQ")
    private Long id;

    @Column(name = "SECTION_NAME", length = ServiceCoreConstants.SECTION_NAME_LENGTH)
    private String sectionName;

    @Column(name = "SECTION_DESCRIPTION", length = ServiceCoreConstants.SECTION_DESCRIPTION_LENGTH)
    private String sectionDescription;

    @OneToMany(mappedBy = "section", fetch = FetchType.EAGER)
    @OrderColumn(name = "QUESTION_ORDER")
    Set<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Section)) {
            return false;
        }

        Section section = (Section) o;

        return new EqualsBuilder()
                .append(id, section.id)
                .append(sectionName, section.sectionName)
                .append(sectionDescription, section.sectionDescription)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(sectionName)
                .append(sectionDescription)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Section {" +
                "id=" + id +
                ", sectionName'" + sectionName + '\'' +
                ", sectionDescription='" + sectionDescription + '\'' +
                '}';
    }

}
