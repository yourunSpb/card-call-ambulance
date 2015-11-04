package ru.ccamgmt.domain.entity.section;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import ru.ccamgmt.domain.entity.CardCall;
import ru.ccamgmt.domain.entity.ServiceCoreConstants;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "QUESTION_ID", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CARD_CALL_ID", nullable = false)
    private CardCall cardCall;

    @Column(name = "ANSWER_VALUE", length = ServiceCoreConstants.LOOKUP_ANSWER_VALUE_LENGTH)
    private String answerValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public CardCall getCardCall() {
        return cardCall;
    }

    public void setCardCall(CardCall cardCall) {
        this.cardCall = cardCall;
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
                .append(cardCall, lookupSection.cardCall)
                .append(question, lookupSection.question)
                .append(answer, lookupSection.answer)
                .append(answerValue, lookupSection.answerValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(cardCall)
                .append(question)
                .append(answer)
                .append(answerValue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "LookupSection {" +
                "id=" + id +
                ", cardCall'" + cardCall + '\'' +
                ", question'" + question + '\'' +
                ", answer'" + answer + '\'' +
                ", answerValue='" + answerValue + '\'' +
                '}';
    }
}
