package ru.ccamgmt.contracts;

import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CardCallDetails  {
  
  private Long cardCallId = null;
  private String createDateTime = null;
  private String status = null;
  private String updatedBy = null;
  private Date updatedDataTime = null;
  private Long brigadeNumber = null;
  private String departmentName = null;
  private String profile = null;

  
  /**
   * card call id in system
   **/
  @ApiModelProperty(value = "card call id in system")
  @JsonProperty("cardCallId")
  public Long getCardCallId() {
    return cardCallId;
  }
  public void setCardCallId(Long cardCallId) {
    this.cardCallId = cardCallId;
  }

  
  /**
   * Data Time
   **/
  @ApiModelProperty(value = "Data Time")
  @JsonProperty("createDateTime")
  public String getCreateDateTime() {
    return createDateTime;
  }
  public void setCreateDateTime(String createDateTime) {
    this.createDateTime = createDateTime;
  }

  
  /**
   * status
   **/
  @ApiModelProperty(value = "status")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  
  /**
   * updatedBy
   **/
  @ApiModelProperty(value = "updatedBy")
  @JsonProperty("updatedBy")
  public String getUpdatedBy() {
    return updatedBy;
  }
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  
  /**
   * updatedDateTime
   **/
  @ApiModelProperty(value = "updatedDateTime")
  @JsonProperty("updatedDataTime")
  public Date getUpdatedDataTime() {
    return updatedDataTime;
  }
  public void setUpdatedDataTime(Date updatedDataTime) {
    this.updatedDataTime = updatedDataTime;
  }

  
  /**
   * brigade number
   **/
  @ApiModelProperty(value = "brigade number")
  @JsonProperty("brigadeNumber")
  public Long getBrigadeNumber() {
    return brigadeNumber;
  }
  public void setBrigadeNumber(Long brigadeNumber) {
    this.brigadeNumber = brigadeNumber;
  }

  
  /**
   * department name
   **/
  @ApiModelProperty(value = "department name")
  @JsonProperty("departmentName")
  public String getDepartmentName() {
    return departmentName;
  }
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  
  /**
   * profile name
   **/
  @ApiModelProperty(value = "profile name")
  @JsonProperty("profile")
  public String getProfile() {
    return profile;
  }
  public void setProfile(String profile) {
    this.profile = profile;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardCallDetails {\n");
    
    sb.append("  cardCallId: ").append(cardCallId).append("\n");
    sb.append("  createDateTime: ").append(createDateTime).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  updatedBy: ").append(updatedBy).append("\n");
    sb.append("  updatedDataTime: ").append(updatedDataTime).append("\n");
    sb.append("  brigadeNumber: ").append(brigadeNumber).append("\n");
    sb.append("  departmentName: ").append(departmentName).append("\n");
    sb.append("  profile: ").append(profile).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
