package br.com.acbueno.entity;

import br.com.acbueno.entity.enums.PhoneType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "phone")
@Data
public class Phone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "number")
  @NotEmpty
  private String number;

  @Enumerated(EnumType.STRING)
  private PhoneType phoneType;

  @ManyToOne
  @JoinColumn(name="id_contact", nullable=true)
  private Contact contact;

}
