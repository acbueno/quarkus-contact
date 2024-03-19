package br.com.acbueno.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ContactResponseDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("alias")
  private String alias;

  @JsonProperty("addresses")
  private List<AddressResponseDTO> addresses;

  @JsonProperty("phone")
  private List<PhoneResponseDTO> phone;

}
