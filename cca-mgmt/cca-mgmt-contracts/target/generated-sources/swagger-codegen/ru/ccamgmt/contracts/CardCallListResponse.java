package ru.ccamgmt.contracts;

import java.util.*;
import ru.ccamgmt.contracts.CardCallDetails;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CardCallListResponse  {
  
  private List<CardCallDetails> cardCalls = new ArrayList<CardCallDetails>() ;

  
  /**
   * CardCall details
   **/
  @ApiModelProperty(value = "CardCall details")
  @JsonProperty("cardCalls")
  public List<CardCallDetails> getCardCalls() {
    return cardCalls;
  }
  public void setCardCalls(List<CardCallDetails> cardCalls) {
    this.cardCalls = cardCalls;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardCallListResponse {\n");
    
    sb.append("  cardCalls: ").append(cardCalls).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
