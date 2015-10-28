package ru.ccamgmt.domain.entity.medic;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yuriy Stolyarenko on 20.10.2015.
 */
@Entity
@Table(name = "MEDIC_USER")
@SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "SEQ_USER_ID")
public class MedicUser implements Serializable {

    private static final long serialVersionUID = -3464910279025378784L;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "E_MAIL_ADDRESS")
    private String eMailAddress;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "medicUser", cascade = CascadeType.ALL)
    private Medic medic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MedicUser)) {
            return false;
        }

        MedicUser medicUser = (MedicUser) o;

        return new EqualsBuilder()
                .append(id, medicUser.id)
                .append(firstName, medicUser.firstName)
                .append(middleName, medicUser.middleName)
                .append(lastName, medicUser.lastName)
                .append(eMailAddress, medicUser.eMailAddress)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(middleName)
                .append(lastName)
                .append(eMailAddress)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "MedicUser {" +
                "id=" + id +
                ", firstName'" + firstName + '\'' +
                ", middleName'" + middleName + '\'' +
                ", lastName'" + lastName + '\'' +
                ", eMailAddress'" + eMailAddress + '\'' +
                '}';
    }
}
