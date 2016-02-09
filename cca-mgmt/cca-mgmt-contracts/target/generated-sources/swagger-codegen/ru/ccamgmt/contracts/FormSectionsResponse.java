package ru.ccamgmt.contracts;

import ru.ccamgmt.contracts.SectionDetails;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class FormSectionsResponse  {
  
  private List<SectionDetails> sections = new ArrayList<SectionDetails>() ;

  
  /**
   * Section details
   **/
  @ApiModelProperty(value = "Section details")
  @JsonProperty("sections")
  public List<SectionDetails> getSections() {
    return sections;
  }
  public void setSections(List<SectionDetails> sections) {
    this.sections = sections;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormSectionsResponse {\n");
    
    sb.append("  sections: ").append(sections).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
