package ru.ccamgmt.contracts;

import java.util.*;
import ru.ccamgmt.contracts.MedicDetails;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class MedicsResponse  {
  
  private List<MedicDetails> medics = new ArrayList<MedicDetails>() ;

  
  /**
   * Medic details
   **/
  @ApiModelProperty(value = "Medic details")
  @JsonProperty("medics")
  public List<MedicDetails> getMedics() {
    return medics;
  }
  public void setMedics(List<MedicDetails> medics) {
    this.medics = medics;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MedicsResponse {\n");
    
    sb.append("  medics: ").append(medics).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
