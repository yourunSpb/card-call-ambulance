package ru.ccamgmt.contracts;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class LookupSectionDetails  {
  
  private Long lookupSectionId = null;
  private Long questionId = null;
  private Long answerId = null;
  private String answerValue = null;

  
  /**
   * If this field is present then update the lookup section with the current ID
   **/
  @ApiModelProperty(value = "If this field is present then update the lookup section with the current ID")
  @JsonProperty("lookupSectionId")
  public Long getLookupSectionId() {
    return lookupSectionId;
  }
  public void setLookupSectionId(Long lookupSectionId) {
    this.lookupSectionId = lookupSectionId;
  }

  
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
   * answer id in system
   **/
  @ApiModelProperty(value = "answer id in system")
  @JsonProperty("answerId")
  public Long getAnswerId() {
    return answerId;
  }
  public void setAnswerId(Long answerId) {
    this.answerId = answerId;
  }

  
  /**
   * answer value
   **/
  @ApiModelProperty(value = "answer value")
  @JsonProperty("answerValue")
  public String getAnswerValue() {
    return answerValue;
  }
  public void setAnswerValue(String answerValue) {
    this.answerValue = answerValue;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class LookupSectionDetails {\n");
    
    sb.append("  lookupSectionId: ").append(lookupSectionId).append("\n");
    sb.append("  questionId: ").append(questionId).append("\n");
    sb.append("  answerId: ").append(answerId).append("\n");
    sb.append("  answerValue: ").append(answerValue).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
