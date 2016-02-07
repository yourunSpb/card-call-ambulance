package ru.ccamgmt.domain.entity.section;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import ru.ccamgmt.domain.entity.CardCall;
import ru.ccamgmt.domain.entity.ServiceCoreConstants;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Stolyarenko on 20.10.2015.
 */

@Entity
@Table(name = "LOOKUP_SECTION")
@SequenceGenerator(name = "LOOKUP_ID_SEQ", sequenceName = "SEQ_LOOKUP_ID")
public class LookupSection implements Serializable {

    private static final long serialVersionUID = -6642263418934384667L;

    @Id
    @Column(name = "LOOKUP_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOOKUP_ID_SEQ")
    private Long id;

//    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "QUESTION_ID", nullable = false)
    private Long question;

//    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "ANSWER_ID")
    private Long answer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CARD_CALL_ID",referencedColumnName = "CARD_CALL_ID", nullable = false)
    private CardCall cardCallSection;

    @Column(name = "ANSWER_VALUE", length = ServiceCoreConstants.LOOKUP_ANSWER_VALUE_LENGTH)
    private String answerValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestion() {
        return question;
    }

    public void setQuestion(Long question) {
        this.question = question;
    }

    public Long getAnswer() {
        return answer;
    }

    public void setAnswer(Long answer) {
        this.answer = answer;
    }

    public CardCall getCardCallSection() {
        return cardCallSection;
    }

    public void setCardCallSection(CardCall cardCallSection) {
        this.cardCallSection = cardCallSection;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LookupSection)) {
            return false;
        }

        LookupSection lookupSection = (LookupSection) o;

        return new EqualsBuilder()
                .append(id, lookupSection.id)
                .append(cardCallSection, lookupSection.cardCallSection)
                .append(question, lookupSection.question)
                .append(answer, lookupSection.answer)
                .append(answerValue, lookupSection.answerValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(cardCallSection)
                .append(question)
                .append(answer)
                .append(answerValue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "LookupSection {" +
                "id=" + id +
                ", cardCallSection'" + cardCallSection + '\'' +
                ", question'" + question + '\'' +
                ", answer'" + answer + '\'' +
                ", answerValue='" + answerValue + '\'' +
                '}';
    }
}
