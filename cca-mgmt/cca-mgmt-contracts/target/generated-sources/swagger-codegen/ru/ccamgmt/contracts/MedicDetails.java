package ru.ccamgmt.contracts;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class MedicDetails  {
  
  private Long medicId = null;
  private String firstName = null;
  private String middleName = null;
  private String position = null;

  
  /**
   * medic id in system
   **/
  @ApiModelProperty(value = "medic id in system")
  @JsonProperty("medicId")
  public Long getMedicId() {
    return medicId;
  }
  public void setMedicId(Long medicId) {
    this.medicId = medicId;
  }

  
  /**
   * first name
   **/
  @ApiModelProperty(value = "first name")
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  
  /**
   * middle name
   **/
  @ApiModelProperty(value = "middle name")
  @JsonProperty("middleName")
  public String getMiddleName() {
    return middleName;
  }
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  
  /**
   * medic position
   **/
  @ApiModelProperty(value = "medic position")
  @JsonProperty("position")
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MedicDetails {\n");
    
    sb.append("  medicId: ").append(medicId).append("\n");
    sb.append("  firstName: ").append(firstName).append("\n");
    sb.append("  middleName: ").append(middleName).append("\n");
    sb.append("  position: ").append(position).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
