package br.com.acbueno.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "city")
  @NotEmpty
  private String city;

  @Column(name = "neighborhood")
  @NotEmpty
  private String neighborhood;

  @Column(name = "zip_code")
  @NotEmpty
  private String zipCode;

  @Column(name = "number")
  @NotEmpty
  private String number;

  @Column(name = "note", nullable = true)
  private String note;

  @ManyToOne
  @JoinColumn(name="id_contact", nullable=true)
  private Contact contact;

}
