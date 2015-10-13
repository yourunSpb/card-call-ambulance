package ru.ccamgmt.domain.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Владимир on 13.10.2015.
 */
@Entity
@Table(name = "ANSWER")
@SequenceGenerator(name = "ANSWER_ID_SEQ", sequenceName = "SEQ_ANSWER_ID")
@NamedQueries({
        @NamedQuery(name = "Answer.getAnswerByQuestion",
                query = "select a from Answer a where a.question.id = :questionId")
})
public class Answer implements Serializable {

    private static final long serialVersionUID = -9175340245932048604L;

    @Id
    @Column(name = "ANSWER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWER_ID_SEQ")
    private Long id;

    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Question question;

    @Column(name = "ANSWER_VALUE", length = ServiceCoreConstants.ANSWER_VALUE_LENGTH)
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

        if (!(o instanceof Answer)) {
            return false;
        }

        Answer answer = (Answer) o;

        return new EqualsBuilder()
                .append(id, answer.id)
                .append(question, answer.question)
                .append(answerValue, answer.answerValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(question)
                .append(answerValue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Answer {" +
                "id=" + id +
                ", question'" + question + '\'' +
                ", answerValue='" + answerValue + '\'' +
                '}';
    }
}
