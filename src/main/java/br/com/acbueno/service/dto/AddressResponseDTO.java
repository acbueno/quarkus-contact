package br.com.acbueno.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressResponseDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("city")
  private  String city;

  @JsonProperty("neighborhood")
  private String neighborhood;

  @JsonProperty("zip-code")
  private String zipCode;

  @JsonProperty("number")
  private String number;

  @JsonProperty("note")
  private String note;

}
