package br.com.acbueno.service.client.dto;

import lombok.Data;

@Data
public class ZipCodeDTO {

  private String cep;

  private String bairro;

  private String uf;

  private String logradouro;

  private String localidade;


}
