package br.com.acbueno.service.mapper;

import org.modelmapper.ModelMapper;
import br.com.acbueno.entity.Phone;
import br.com.acbueno.service.dto.PhoneRequestDTO;
import br.com.acbueno.service.dto.PhoneResponseDTO;

public class PhoneMapper {

  public static PhoneResponseDTO convertDTO(Phone phone) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(phone, PhoneResponseDTO.class);
  }

  public static Phone convertEntity(PhoneRequestDTO phoneDTO) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(phoneDTO, Phone.class);
  }

}
