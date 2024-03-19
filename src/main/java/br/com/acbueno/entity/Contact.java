package br.com.acbueno.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "contact")
@Data
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  @NotEmpty
  private String name;

  @Column(name = "alias")
  @NotEmpty
  private String alias;

  @OneToMany(cascade = CascadeType.REMOVE,
      orphanRemoval = false,
      fetch = FetchType.EAGER)
  @JoinColumn(name = "id_contact")
  private List<Address> addresses;

  @OneToMany(cascade = CascadeType.REMOVE,
      orphanRemoval = false,
      fetch = FetchType.EAGER)
  @JoinColumn(name = "id_contact")
  private List<Phone> phone;

}
