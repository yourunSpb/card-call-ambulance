package ru.ccamgmt.contracts;

import java.util.Date;
import ru.ccamgmt.contracts.LookupSectionDetails;
import java.util.*;
import ru.ccamgmt.contracts.BrigadeDetails;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class AddCardCallRequest  {
  
  private Long cardCallId = null;
  private BrigadeDetails brigade = null;
  private List<LookupSectionDetails> sections = new ArrayList<LookupSectionDetails>() ;
  private Long updatedBy = null;
  private Date updateDate = null;

  
  /**
   * If this field is present then update the card with the current call ID
   **/
  @ApiModelProperty(value = "If this field is present then update the card with the current call ID")
  @JsonProperty("cardCallId")
  public Long getCardCallId() {
    return cardCallId;
  }
  public void setCardCallId(Long cardCallId) {
    this.cardCallId = cardCallId;
  }

  
  /**
   * brigade details
   **/
  @ApiModelProperty(value = "brigade details")
  @JsonProperty("brigade")
  public BrigadeDetails getBrigade() {
    return brigade;
  }
  public void setBrigade(BrigadeDetails brigade) {
    this.brigade = brigade;
  }

  
  /**
   * lookup section
   **/
  @ApiModelProperty(value = "lookup section")
  @JsonProperty("sections")
  public List<LookupSectionDetails> getSections() {
    return sections;
  }
  public void setSections(List<LookupSectionDetails> sections) {
    this.sections = sections;
  }

  
  /**
   * medic id in system
   **/
  @ApiModelProperty(value = "medic id in system")
  @JsonProperty("updatedBy")
  public Long getUpdatedBy() {
    return updatedBy;
  }
  public void setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
  }

  
  /**
   * update date
   **/
  @ApiModelProperty(value = "update date")
  @JsonProperty("updateDate")
  public Date getUpdateDate() {
    return updateDate;
  }
  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddCardCallRequest {\n");
    
    sb.append("  cardCallId: ").append(cardCallId).append("\n");
    sb.append("  brigade: ").append(brigade).append("\n");
    sb.append("  sections: ").append(sections).append("\n");
    sb.append("  updatedBy: ").append(updatedBy).append("\n");
    sb.append("  updateDate: ").append(updateDate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
