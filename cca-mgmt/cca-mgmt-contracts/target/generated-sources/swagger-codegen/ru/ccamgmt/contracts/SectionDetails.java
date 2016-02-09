package ru.ccamgmt.contracts;

import ru.ccamgmt.contracts.QuestionDetails;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SectionDetails  {
  
  private Long sectionId = null;
  private String sectionDescription = null;
  private String sectionName = null;
  private List<QuestionDetails> questions = new ArrayList<QuestionDetails>() ;

  
  /**
   * section id in system
   **/
  @ApiModelProperty(value = "section id in system")
  @JsonProperty("sectionId")
  public Long getSectionId() {
    return sectionId;
  }
  public void setSectionId(Long sectionId) {
    this.sectionId = sectionId;
  }

  
  /**
   * section description
   **/
  @ApiModelProperty(value = "section description")
  @JsonProperty("sectionDescription")
  public String getSectionDescription() {
    return sectionDescription;
  }
  public void setSectionDescription(String sectionDescription) {
    this.sectionDescription = sectionDescription;
  }

  
  /**
   * section name in system
   **/
  @ApiModelProperty(value = "section name in system")
  @JsonProperty("sectionName")
  public String getSectionName() {
    return sectionName;
  }
  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  
  /**
   * list of questions
   **/
  @ApiModelProperty(value = "list of questions")
  @JsonProperty("questions")
  public List<QuestionDetails> getQuestions() {
    return questions;
  }
  public void setQuestions(List<QuestionDetails> questions) {
    this.questions = questions;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SectionDetails {\n");
    
    sb.append("  sectionId: ").append(sectionId).append("\n");
    sb.append("  sectionDescription: ").append(sectionDescription).append("\n");
    sb.append("  sectionName: ").append(sectionName).append("\n");
    sb.append("  questions: ").append(questions).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
