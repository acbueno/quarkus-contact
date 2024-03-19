package br.com.acbueno.entity.enums;

import lombok.Getter;

@Getter
public enum PhoneType {
  CELL(1, "CELLPHONE"),
  RESIDENTIAL(2, "RESIDENTIAL"),
  BUSINESS(3, "BUSINESS");

  private int code;

  private String description;

  private PhoneType(int code, String description) {
    this.code = code;
    this.description = description;
  }

}
