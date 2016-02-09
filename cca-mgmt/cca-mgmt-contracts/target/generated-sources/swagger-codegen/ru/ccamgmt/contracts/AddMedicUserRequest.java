package ru.ccamgmt.contracts;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class AddMedicUserRequest  {
  
  private String firstName = null;
  private String lastName = null;
  private Long medicPositionId = null;
  private String middleName = null;
  private String mailAddress = null;
  private List<Long> roleList = new ArrayList<Long>() ;

  
  /**
   * brigade details
   **/
  @ApiModelProperty(value = "brigade details")
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  
  /**
   * brigade details
   **/
  @ApiModelProperty(value = "brigade details")
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  
  /**
   * medicPosition
   **/
  @ApiModelProperty(value = "medicPosition")
  @JsonProperty("medicPositionId")
  public Long getMedicPositionId() {
    return medicPositionId;
  }
  public void setMedicPositionId(Long medicPositionId) {
    this.medicPositionId = medicPositionId;
  }

  
  /**
   * middleNameUser
   **/
  @ApiModelProperty(value = "middleNameUser")
  @JsonProperty("middleName")
  public String getMiddleName() {
    return middleName;
  }
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  
  /**
   * mailAddressUser
   **/
  @ApiModelProperty(value = "mailAddressUser")
  @JsonProperty("mailAddress")
  public String getMailAddress() {
    return mailAddress;
  }
  public void setMailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("roleList")
  public List<Long> getRoleList() {
    return roleList;
  }
  public void setRoleList(List<Long> roleList) {
    this.roleList = roleList;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddMedicUserRequest {\n");
    
    sb.append("  firstName: ").append(firstName).append("\n");
    sb.append("  lastName: ").append(lastName).append("\n");
    sb.append("  medicPositionId: ").append(medicPositionId).append("\n");
    sb.append("  middleName: ").append(middleName).append("\n");
    sb.append("  mailAddress: ").append(mailAddress).append("\n");
    sb.append("  roleList: ").append(roleList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
