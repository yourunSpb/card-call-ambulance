package ru.ccamgmt.contracts;

import ru.ccamgmt.contracts.DepartmentDetails;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class DepartmentsResponse  {
  
  private List<DepartmentDetails> departments = new ArrayList<DepartmentDetails>() ;

  
  /**
   * Department details
   **/
  @ApiModelProperty(value = "Department details")
  @JsonProperty("departments")
  public List<DepartmentDetails> getDepartments() {
    return departments;
  }
  public void setDepartments(List<DepartmentDetails> departments) {
    this.departments = departments;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepartmentsResponse {\n");
    
    sb.append("  departments: ").append(departments).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
