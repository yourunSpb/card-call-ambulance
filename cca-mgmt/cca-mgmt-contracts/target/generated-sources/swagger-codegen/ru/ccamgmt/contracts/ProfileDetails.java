package ru.ccamgmt.contracts;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ProfileDetails  {
  
  private Long profileId = null;
  private String reduction = null;
  private String transcript = null;

  
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
   * reduction
   **/
  @ApiModelProperty(value = "reduction")
  @JsonProperty("reduction")
  public String getReduction() {
    return reduction;
  }
  public void setReduction(String reduction) {
    this.reduction = reduction;
  }

  
  /**
   * transcript
   **/
  @ApiModelProperty(value = "transcript")
  @JsonProperty("transcript")
  public String getTranscript() {
    return transcript;
  }
  public void setTranscript(String transcript) {
    this.transcript = transcript;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfileDetails {\n");
    
    sb.append("  profileId: ").append(profileId).append("\n");
    sb.append("  reduction: ").append(reduction).append("\n");
    sb.append("  transcript: ").append(transcript).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
