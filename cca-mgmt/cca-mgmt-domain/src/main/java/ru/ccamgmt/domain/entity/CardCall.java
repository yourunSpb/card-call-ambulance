package ru.ccamgmt.domain.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import ru.ccamgmt.domain.entity.brigade.Brigade;
import ru.ccamgmt.domain.entity.medic.Medic;
import ru.ccamgmt.domain.entity.section.LookupSection;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 20.10.2015.
 */
@Entity
@Table(name = "CARD_CALL")
@SequenceGenerator(name = "CARD_ID_SEQ", sequenceName = "SEQ_CARD_ID")
public class CardCall implements Serializable {

    private static final long serialVersionUID = -1531798564057221844L;

    @Id
    @Column(name = "CARD_CALL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_ID_SEQ")
    private Long id;


    @Column(name = "CREATE_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "STATUS", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    public StatusType status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UPDATED_BY", referencedColumnName = "MEDIC_ID")
    private Medic updateBy;

    @Column(name = "UPDATE_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Lob
    @Column(name = "CARD_CALL_CONTENT", length = Integer.MAX_VALUE)
    private byte[] cardCallContent;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "BRIGADE_ID", referencedColumnName = "BRIGADE_ID")
    private Brigade brigade;

    @OneToMany(mappedBy = "cardCall", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LookupSection> lookupSections;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Medic getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Medic updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public Set<LookupSection> getLookupSections() {
        return lookupSections;
    }

    public void setLookupSections(Set<LookupSection> lookupSections) {
        this.lookupSections = lookupSections;
    }


    public byte[] getItemContent() {
        if(cardCallContent == null) {
            return null;
        } else {
            return Arrays.copyOf(cardCallContent, cardCallContent.length);
        }
    }

    public void setItemContent(byte[] cardCallContent) {
        if(cardCallContent == null) {
            this.cardCallContent = new byte[0];
        } else {
            this.cardCallContent = Arrays.copyOf(cardCallContent, cardCallContent.length);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CardCall)) {
            return false;
        }

        CardCall cardCall = (CardCall) o;

        return new EqualsBuilder()
                .append(id, cardCall.id)
                .append(createDate, cardCall.createDate)
                .append(status, cardCall.status)
                .append(updateBy, cardCall.updateBy)
                .append(updateDate, cardCall.updateDate)
                .append(cardCallContent, cardCall.cardCallContent)
                .append(brigade, cardCall.brigade)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(createDate)
                .append(status)
                .append(updateBy)
                .append(updateDate)
                .append(cardCallContent)
                .append(brigade)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CardCall {" +
                "id=" + id +
                ", createDate'" + createDate + '\'' +
                ", status='" + status + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", brigade='" + brigade + '\'' +
                '}';
    }


}
