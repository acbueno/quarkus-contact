package br.com.acbueno.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.acbueno.entity.enums.PhoneType;
import lombok.Data;

@Data
public class PhoneRequestDTO {

  @JsonProperty("number")
  private String number;

  @JsonProperty("phone-type")
  private PhoneType phoneType;


}
