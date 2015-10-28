package ru.ccamgmt.domain.entity.medic;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 20.10.2015.
 */
@Entity
@Table(name = "USER_ROLE")
@SequenceGenerator(name = "ROLE_ID_SEQ", sequenceName = "SEQ_ROLE_ID")
public class MedicRole implements Serializable {

    private static final long serialVersionUID = 1909482017200814964L;

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_SEQ")
    private Long id;

    @Column(name = "ROLE_VALUE")
    private String roleValue;

    @ManyToMany(mappedBy = "medicRoles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Medic> medics;

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        if (!(o instanceof MedicRole)) {
            return false;
        }

        MedicRole userRole = (MedicRole) o;

        return new EqualsBuilder()
                .append(id, userRole.id)
                .append(roleValue, userRole.roleValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(roleValue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "MedicRole {" +
                "id=" + id +
                ", roleValue'" + roleValue + '\'' +
                '}';
    }
}
