package ru.ccamgmt.contracts;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class AnswerDetails  {
  
  private Long answerId = null;
  private String answerValue = null;

  
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
    sb.append("class AnswerDetails {\n");
    
    sb.append("  answerId: ").append(answerId).append("\n");
    sb.append("  answerValue: ").append(answerValue).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
