package ru.ccamgmt.contracts;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class BrigadeDetails  {
  
  private Long brigadeId = null;
  private Long brigadeNumber = null;
  private Long departmentId = null;
  private Long profileId = null;
  private List<Long> medicList = new ArrayList<Long>() ;

  
  /**
   * If this field is present then update the bridate with the current brigade ID
   **/
  @ApiModelProperty(value = "If this field is present then update the bridate with the current brigade ID")
  @JsonProperty("brigadeId")
  public Long getBrigadeId() {
    return brigadeId;
  }
  public void setBrigadeId(Long brigadeId) {
    this.brigadeId = brigadeId;
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
   * department id in system
   **/
  @ApiModelProperty(value = "department id in system")
  @JsonProperty("departmentId")
  public Long getDepartmentId() {
    return departmentId;
  }
  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  
  /**
   * profile id in system
   **/
  @ApiModelProperty(value = "profile id in system")
  @JsonProperty("profileId")
  public Long getProfileId() {
    return profileId;
  }
  public void setProfileId(Long profileId) {
    this.profileId = profileId;
  }

  
  /**
   * List ID of medical
   **/
  @ApiModelProperty(value = "List ID of medical")
  @JsonProperty("medicList")
  public List<Long> getMedicList() {
    return medicList;
  }
  public void setMedicList(List<Long> medicList) {
    this.medicList = medicList;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BrigadeDetails {\n");
    
    sb.append("  brigadeId: ").append(brigadeId).append("\n");
    sb.append("  brigadeNumber: ").append(brigadeNumber).append("\n");
    sb.append("  departmentId: ").append(departmentId).append("\n");
    sb.append("  profileId: ").append(profileId).append("\n");
    sb.append("  medicList: ").append(medicList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
