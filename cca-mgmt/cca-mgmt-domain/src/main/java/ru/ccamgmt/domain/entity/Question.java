package ru.ccamgmt.domain.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Владимир on 13.10.2015.
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

    @JoinColumn(name = "CHECKLIST_ID", referencedColumnName = "CHECKLIST_ID")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Checklist checklist;

    @Column(name = "QUESTION_ORDER")
    private Long questionOrder;

    @Column(name = "QUESTION_TEXT", length = ServiceCoreConstants.QUESTION_TEXT_LENGTH)
    private String questionText;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "ANSWER",
            joinColumns = {@JoinColumn(name="QUESTION_ID", referencedColumnName = "QUESTION_ID")}
    )
    private List<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
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
                .append(checklist, question.checklist)
                .append(questionOrder, question.questionOrder)
                .append(questionText, question.questionText)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(checklist)
                .append(questionOrder)
                .append(questionText)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Question {" +
                "id=" + id +
                ", checklist'" + checklist + '\'' +
                ", questionOrder='" + questionOrder + '\'' +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}
