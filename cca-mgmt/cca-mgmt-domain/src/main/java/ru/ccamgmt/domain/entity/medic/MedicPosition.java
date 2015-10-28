package ru.ccamgmt.domain.entity.medic;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yuriy Stolyarenko on 20.10.2015.
 */
@Entity
@Table(name = "MEDIC_POSITION")
@SequenceGenerator(name = "POSITION_ID_SEQ", sequenceName = "SEQ_ROLE_ID")
public class MedicPosition implements Serializable {

    private static final long serialVersionUID = -4700076586926601438L;

    @Id
    @Column(name = "POSITION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSITION_ID_SEQ")
    private Long id;

    @Column(name = "POSITION_VALUE")
    private String positionValue;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "medicPosition", cascade = CascadeType.ALL)
    private Medic medic;

    public String getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(String positionValue) {
        this.positionValue = positionValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        if (!(o instanceof MedicPosition)) {
            return false;
        }

        MedicPosition medicPosition = (MedicPosition) o;

        return new EqualsBuilder()
                .append(id, medicPosition.id)
                .append(positionValue, medicPosition.positionValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(positionValue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "MedicPosition {" +
                "id=" + id +
                ", positionValue'" + positionValue + '\'' +
                '}';
    }
}
