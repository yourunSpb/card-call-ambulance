package ru.ccamgmt.contracts;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class DepartmentDetails  {
  
  private Long departmentId = null;
  private String departmentName = null;

  
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepartmentDetails {\n");
    
    sb.append("  departmentId: ").append(departmentId).append("\n");
    sb.append("  departmentName: ").append(departmentName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
