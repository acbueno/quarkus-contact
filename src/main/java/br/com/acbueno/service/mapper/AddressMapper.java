package br.com.acbueno.service.mapper;

import org.modelmapper.ModelMapper;
import br.com.acbueno.entity.Address;
import br.com.acbueno.service.dto.AddressRequestDTO;
import br.com.acbueno.service.dto.AddressResponseDTO;

public class AddressMapper {

  public static AddressResponseDTO convertEntityToDTO(Address address) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(address, AddressResponseDTO.class);
  }

  public static Address convertEntity(AddressRequestDTO addressDTO) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(addressDTO, Address.class);
  }

}
