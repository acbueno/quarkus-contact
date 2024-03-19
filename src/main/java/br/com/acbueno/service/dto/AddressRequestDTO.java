package br.com.acbueno.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddressRequestDTO {

  @JsonProperty("zip-code")
  private Integer zipCode;

  @JsonProperty("number")
  private String number;

  @JsonProperty("note")
  private String note;

}
