package ru.ccamgmt.contracts;

import ru.ccamgmt.contracts.AnswerDetails;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class QuestionDetails  {
  
  private Long questionId = null;
  private Long questionOrder = null;
  private String answerType = null;
  private String questionText = null;
  private List<AnswerDetails> answers = new ArrayList<AnswerDetails>() ;

  
  /**
   * question id in system
   **/
  @ApiModelProperty(value = "question id in system")
  @JsonProperty("questionId")
  public Long getQuestionId() {
    return questionId;
  }
  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  
  /**
   * questions order
   **/
  @ApiModelProperty(value = "questions order")
  @JsonProperty("questionOrder")
  public Long getQuestionOrder() {
    return questionOrder;
  }
  public void setQuestionOrder(Long questionOrder) {
    this.questionOrder = questionOrder;
  }

  
  /**
   * answer type ('TEXT_BOX', 'NEW_CHECK_BOX')
   **/
  @ApiModelProperty(value = "answer type ('TEXT_BOX', 'NEW_CHECK_BOX')")
  @JsonProperty("answerType")
  public String getAnswerType() {
    return answerType;
  }
  public void setAnswerType(String answerType) {
    this.answerType = answerType;
  }

  
  /**
   * question text
   **/
  @ApiModelProperty(value = "question text")
  @JsonProperty("questionText")
  public String getQuestionText() {
    return questionText;
  }
  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  
  /**
   * Answer details
   **/
  @ApiModelProperty(value = "Answer details")
  @JsonProperty("answers")
  public List<AnswerDetails> getAnswers() {
    return answers;
  }
  public void setAnswers(List<AnswerDetails> answers) {
    this.answers = answers;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionDetails {\n");
    
    sb.append("  questionId: ").append(questionId).append("\n");
    sb.append("  questionOrder: ").append(questionOrder).append("\n");
    sb.append("  answerType: ").append(answerType).append("\n");
    sb.append("  questionText: ").append(questionText).append("\n");
    sb.append("  answers: ").append(answers).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
