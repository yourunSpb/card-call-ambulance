package ru.ccamgmt.contracts;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ErrorResponse  {
  
  private Integer code = null;
  private String message = null;
  private String details = null;

  
  /**
   * Error code.
   * minimum: 100.0
   * maximum: 600.0
   **/
  @ApiModelProperty(required = true, value = "Error code.")
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  
  /**
   * Error message (in user displayable format)
   **/
  @ApiModelProperty(required = true, value = "Error message (in user displayable format)")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  
  /**
   * Technical details of the error (i.e. stack trace, etc.) that would assist in troubleshooting the error, but are not intended for end user
   **/
  @ApiModelProperty(value = "Technical details of the error (i.e. stack trace, etc.) that would assist in troubleshooting the error, but are not intended for end user")
  @JsonProperty("details")
  public String getDetails() {
    return details;
  }
  public void setDetails(String details) {
    this.details = details;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  details: ").append(details).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
