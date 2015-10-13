package ru.ccamgmt.domain.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Владимир on 13.10.2015.
 */
@Entity
@Table(name = "CHECKLIST")
@SequenceGenerator(name = "CHECKLIST_ID_SEQ", sequenceName = "SEQ_CHECKLIST_ID")
public class Checklist implements Serializable {

    private static final long serialVersionUID = -2540435326860743350L;

    @Id
    @Column(name = "CHECKLIST_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHECKLIST_ID_SEQ")
    private Long id;

    @Column(name = "CHECKLIST_NAME", length = ServiceCoreConstants.CHECKLIST_NAME_LENGTH)
    private String checklistName;

    @Column(name = "CHECKLIST_DESCRIPTION", length = ServiceCoreConstants.CHECKLIST_DESCRIPTION_LENGTH)
    private String checklistDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChecklistName() {
        return checklistName;
    }

    public void setChecklistName(String checklistName) {
        this.checklistName = checklistName;
    }

    public String getChecklistDescription() {
        return checklistDescription;
    }

    public void setChecklistDescription(String checklistDescription) {
        this.checklistDescription = checklistDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Checklist)) {
            return false;
        }

        Checklist checklist = (Checklist) o;

        return new EqualsBuilder()
                .append(id, checklist.id)
                .append(checklistName, checklist.checklistName)
                .append(checklistDescription, checklist.checklistDescription)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(checklistName)
                .append(checklistDescription)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Checklist {" +
                "id=" + id +
                ", checklistName'" + checklistName + '\'' +
                ", checklistDescription='" + checklistDescription + '\'' +
                '}';
    }

}
