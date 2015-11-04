package ru.ccamgmt.domain.entity.brigade;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 25.10.2015.
 */
@Entity
@Table(name = "BRIGADE_PROFILE")
@SequenceGenerator(name = "PROFILE_ID_SEQ", sequenceName = "SEQ_PROFILE_ID")
public class BrigadeProfile implements Serializable {

    private static final long serialVersionUID = 1553123114122765170L;

    @Id
    @Column(name = "PROFILE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFILE_ID_SEQ")
    private Long id;

    @Column(name = "REDUCTION")
    private String reduction;

    @Column(name = "TRANSCRIPT")
    private String transcript;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brigadeProfile")
    private Set<Brigade> brigades;

    public BrigadeProfile() {
    }

    public BrigadeProfile(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReduction() {
        return reduction;
    }

    public void setReduction(String reduction) {
        this.reduction = reduction;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public Set<Brigade> getBrigades() {
        return brigades;
    }

    public void setBrigades(Set<Brigade> brigades) {
        this.brigades = brigades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BrigadeProfile)) {
            return false;
        }

        BrigadeProfile o1 = (BrigadeProfile) o;

        return new EqualsBuilder()
                .append(id, o1.id)
                .append(reduction, o1.reduction)
                .append(transcript, o1.transcript)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(reduction)
                .append(transcript)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "BrigadeProfile {" +
                "id=" + id +
                ", reduction'" + reduction + '\'' +
                ", transcript'" + transcript + '\'' +
                '}';
    }
}
