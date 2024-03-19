package br.com.acbueno.service.mapper;

import org.modelmapper.ModelMapper;
import br.com.acbueno.entity.Contact;
import br.com.acbueno.service.dto.ContactRequestDTO;
import br.com.acbueno.service.dto.ContactResponseDTO;

public class ContactMapper {

  public static ContactResponseDTO convertDTO(Contact entity) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, ContactResponseDTO.class);
  }

  public static Contact convertEntity(ContactRequestDTO dto) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(dto, Contact.class);
  }

}
