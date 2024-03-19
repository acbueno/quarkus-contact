package br.com.acbueno.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactRequestDTO {

  @JsonProperty("name")
  private String name;

  @JsonProperty("alias")
  private String alias;

}
