package ru.ccamgmt.contracts;

import ru.ccamgmt.contracts.ProfileDetails;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ProfileResponse  {
  
  private List<ProfileDetails> profiles = new ArrayList<ProfileDetails>() ;

  
  /**
   * Profile details
   **/
  @ApiModelProperty(value = "Profile details")
  @JsonProperty("profiles")
  public List<ProfileDetails> getProfiles() {
    return profiles;
  }
  public void setProfiles(List<ProfileDetails> profiles) {
    this.profiles = profiles;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfileResponse {\n");
    
    sb.append("  profiles: ").append(profiles).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
