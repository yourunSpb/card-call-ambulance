package ru.ccamgmt.domain.entity.brigade;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import ru.ccamgmt.domain.entity.medic.Medic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 25.10.2015.
 */
@Entity
@Table(name = "BRIGADE")
@SequenceGenerator(name = "BRIGADE_ID_SEQ", sequenceName = "SEQ_BRIGADE_ID")
public class Brigade implements Serializable {

    private static final long serialVersionUID = -5799799199855314818L;

    @Id
    @Column(name = "BRIGADE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRIGADE_ID_SEQ")
    private Long id;

    @Column(name = "BRIGADE_NUMBER")
    private Long brigadeNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private Department department;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "PROFILE_ID")
    private BrigadeProfile brigadeProfile;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="COMPOSITION",
            joinColumns={@JoinColumn(name="BRIGADE_ID", referencedColumnName="BRIGADE_ID")},
            inverseJoinColumns={@JoinColumn(name="MEDIC_ID", referencedColumnName="MEDIC_ID")})
    private Set<Medic> medics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrigadeNumber() {
        return brigadeNumber;
    }

    public void setBrigadeNumber(Long brigadeNumber) {
        this.brigadeNumber = brigadeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BrigadeProfile getBrigadeProfile() {
        return brigadeProfile;
    }

    public void setBrigadeProfile(BrigadeProfile brigadeProfile) {
        this.brigadeProfile = brigadeProfile;
    }

    public Set<Medic> getMedics() {
        return medics;
    }

    public void setMedics(Set<Medic> medics) {
        this.medics = medics;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Brigade)) {
            return false;
        }

        Brigade o1 = (Brigade) o;

        return new EqualsBuilder()
                .append(id, o1.id)
                .append(brigadeNumber, o1.brigadeNumber)
                .append(department, o1.department)
                .append(brigadeProfile, o1.brigadeProfile)
                .append(medics, o1.medics)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(brigadeNumber)
                .append(department)
                .append(brigadeProfile)
                .append(medics)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Brigade {" +
                "id=" + id +
                ", brigadeNumber'" + brigadeNumber + '\'' +
                ", department'" + department + '\'' +
                ", brigadeProfile'" + brigadeProfile + '\'' +
                ", medics'" + medics + '\'' +
                '}';
    }
}
