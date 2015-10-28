package ru.ccamgmt.domain.entity.brigade;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Yuriy Stolyarenko on 25.10.2015.
 */
@Entity
@Table(name = "DEPARTMENT")
@SequenceGenerator(name = "DEP_ID_SEQ", sequenceName = "SEQ_DEP_ID")
public class Department implements Serializable {

    private static final long serialVersionUID = -4879139408365238302L;

    @Id
    @Column(name = "DEPARTMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEP_ID_SEQ")
    private Long id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
    private Brigade brigade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Department)) {
            return false;
        }

        Department o1 = (Department) o;

        return new EqualsBuilder()
                .append(id, o1.id)
                .append(departmentName, o1.departmentName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(departmentName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Department {" +
                "id=" + id +
                ", departmentName'" + departmentName + '\'' +
                '}';
    }
}
