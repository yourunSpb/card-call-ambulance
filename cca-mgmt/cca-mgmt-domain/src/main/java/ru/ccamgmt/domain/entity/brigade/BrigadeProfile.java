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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "BRIGADE_ID", referencedColumnName = "BRIGADE_ID")
    private Brigade brigade;

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
