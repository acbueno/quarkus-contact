package br.com.acbueno.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhoneResponseDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("number")
  private String number;

  @JsonProperty("phone-type")
  private String phoneType;

}
