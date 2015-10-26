package ru.ccamgmt.domain.entity.medic;


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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 20.10.2015.
 */
@Entity
@Table(name = "MEDIC")
@SequenceGenerator(name = "MEDIC_ID_SEQ", sequenceName = "SEQ_MEDIC_ID")
public class Medic implements Serializable {

    private static final long serialVersionUID = 6469600697898623528L;

    @Id
    @Column(name = "MEDIC_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDIC_ID_SEQ")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "POSITION_ID")
    private MedicPosition medicPosition;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private MedicUser medicUser;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="MEDIC_ROLE",
            joinColumns={@JoinColumn(name="MEDIC_ID", referencedColumnName="MEDIC_ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ROLE_ID")})
    private Set<MedicRole> medicRoles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicPosition getMedicPosition() {
        return medicPosition;
    }

    public void setMedicPosition(MedicPosition medicPosition) {
        this.medicPosition = medicPosition;
    }

    public MedicUser getMedicUser() {
        return medicUser;
    }

    public void setMedicUser(MedicUser medicUser) {
        this.medicUser = medicUser;
    }

    public Set<MedicRole> getMedicRoles() {
        return medicRoles;
    }

    public void setMedicRoles(Set<MedicRole> medicRoles) {
        this.medicRoles = medicRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Medic)) {
            return false;
        }

        Medic medic = (Medic) o;

        return new EqualsBuilder()
                .append(id, medic.id)
                .append(medicPosition, medic.medicPosition)
                .append(medicUser, medic.medicUser)
                .append(medicRoles, medic.medicRoles)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(medicPosition)
                .append(medicUser)
                .append(medicRoles)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "MedicPosition {" +
                "id=" + id +
                ", medicPosition'" + medicPosition + '\'' +
                ", medicUser'" + medicUser + '\'' +
                ", medicRoles'" + medicRoles + '\'' +
                '}';
    }
}
