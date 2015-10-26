package ru.ccamgmt.domain.entity.section;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import ru.ccamgmt.domain.entity.ServiceCoreConstants;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 13.10.2015.
 */
@Entity
@Table(name = "QUESTION")
@SequenceGenerator(name = "QUESTION_ID_SEQ", sequenceName = "SEQ_QUESTION_ID")
public class Question implements Serializable {

    private static final long serialVersionUID = 5851328621751699497L;

    @Id
    @Column(name = "QUESTION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_ID_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SECTION_ID", nullable = false)
    private Section section;

    @Column(name = "QUESTION_ORDER")
    private Long questionOrder;

    @Column(name = "QUESTION_TEXT", length = ServiceCoreConstants.QUESTION_TEXT_LENGTH)
    private String questionText;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    @OrderBy("id ASC")
    private Set<Answer> answers;

    @Column(name = "ANSWER_TYPE", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    public AnswerType answerType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOOKUP_ID")
    private Set<LookupSection> lookupSections;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Long getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(Long questionOrder) {
        this.questionOrder = questionOrder;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<LookupSection> getLookupSections() {
        return lookupSections;
    }

    public void setLookupSections(Set<LookupSection> lookupSections) {
        this.lookupSections = lookupSections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Question)) {
            return false;
        }

        Question question = (Question) o;

        return new EqualsBuilder()
                .append(id, question.id)
                .append(section, question.section)
                .append(questionOrder, question.questionOrder)
                .append(questionText, question.questionText)
                .append(answerType, question.answerType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(section)
                .append(questionOrder)
                .append(questionText)
                .append(answerType)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Question {" +
                "id=" + id +
                ", section'" + section + '\'' +
                ", questionOrder='" + questionOrder + '\'' +
                ", questionText='" + questionText + '\'' +
                ", answerType='" + answerType + '\'' +
                '}';
    }
}
