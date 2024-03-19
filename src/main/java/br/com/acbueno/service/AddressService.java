package br.com.acbueno.service;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import br.com.acbueno.entity.Address;
import br.com.acbueno.entity.Contact;
import br.com.acbueno.exception.ServiceException;
import br.com.acbueno.repository.AddressRepository;
import br.com.acbueno.repository.ContactRepository;
import br.com.acbueno.service.client.ZipCodeService;
import br.com.acbueno.service.client.dto.ZipCodeDTO;
import br.com.acbueno.service.dto.AddressRequestDTO;
import br.com.acbueno.service.dto.AddressResponseDTO;
import br.com.acbueno.service.mapper.AddressMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class AddressService {

  @Inject
  private AddressRepository repository;

  @Inject
  private ContactRepository contactRepository;

  @RestClient
  private ZipCodeService zipCodeService;

  public List<AddressResponseDTO> listAllAddress() {
    List<AddressResponseDTO> listAddressResponse = new ArrayList<>();
    repository.getlAllAddress().forEach(e -> {
      listAddressResponse.add(AddressMapper.convertEntityToDTO(e));
    });
    return listAddressResponse;
  }

  public AddressResponseDTO getAddressById(Long id) {
    return AddressMapper.convertEntityToDTO(repository.getAddressById(id));
  }

  public void deleteAddressById(Long id) {
    repository.deleteById(id);
  }

  public void insert(Long idContact, AddressRequestDTO addressDTO) throws ServiceException {
    Address address = mountAddressData(idContact, addressDTO);
    repository.insert(address);
  }

  private Address mountAddressData(Long idContact, AddressRequestDTO addressDTO) throws ServiceException {
    Address address = null;
    ZipCodeDTO zipcode = zipCodeService.getAddressByZipCode(addressDTO.getZipCode());
    Contact contact = contactRepository.getContactById(idContact);

    if (zipcode == null) {
      throw new NotFoundException("Not found ZipCode");
    }

    if (contact == null) {
      throw new NotFoundException("Not contact idContact");
    }

    try {
      address = new Address();
      address.setCity(zipcode.getLocalidade());
      address.setNeighborhood(zipcode.getBairro());
      address.setNumber(addressDTO.getNumber());
      address.setNote(addressDTO.getNote());
      address.setZipCode(String.valueOf(zipcode.getCep()));
      address.setContact(contact);
    } catch (Exception e) {
      throw new ServiceException("Error mount data: {}", e.getCause());
    }

    return address;
  }

  public AddressResponseDTO update(Long id, AddressRequestDTO addressDTO) throws ServiceException {
    Address address = mountAddressData(id, addressDTO);
    return AddressMapper.convertEntityToDTO(repository.updateAddress(id, address));
  }

  public boolean deleteById(Long id) {
    return repository.deleteById(id);
  }
}
