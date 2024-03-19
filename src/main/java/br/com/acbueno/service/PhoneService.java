package br.com.acbueno.service;

import java.util.ArrayList;
import java.util.List;
import br.com.acbueno.entity.Contact;
import br.com.acbueno.entity.Phone;
import br.com.acbueno.exception.ServiceException;
import br.com.acbueno.repository.ContactRepository;
import br.com.acbueno.repository.PhoneRepository;
import br.com.acbueno.service.dto.PhoneRequestDTO;
import br.com.acbueno.service.dto.PhoneResponseDTO;
import br.com.acbueno.service.mapper.PhoneMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PhoneService {

  @Inject
  private PhoneRepository repository;

  @Inject
  private ContactRepository contactRepository;

  public PhoneResponseDTO getPhoneByNumber(String number) {
    return PhoneMapper.convertDTO(repository.getPhoneByNumber(number));
  }

  public PhoneResponseDTO getPhoneById(Long id) {
    return PhoneMapper.convertDTO(repository.findById(id));
  }

  public List<PhoneResponseDTO> getPhoneAll() {
    List<PhoneResponseDTO> listResponse = new ArrayList<>();
    repository.getAllPhone().forEach(e -> {
      listResponse.add(PhoneMapper.convertDTO(e));
    });

    return listResponse;
  }

  @Transactional
  public void deletePhoneById(Long id) {
    repository.deleteById(id);
  }

  public void save(Long idContact, PhoneRequestDTO phoneDTO) throws ServiceException {
    Phone phone = mountPhoneData(idContact, phoneDTO);
    repository.insert(phone);
  }

  private Phone mountPhoneData(Long idContact, PhoneRequestDTO phoneDTO) throws ServiceException {
    Contact contact = contactRepository.getContactById(idContact);
    Phone phone = null;

    if (contact == null) {
      throw new NotFoundException("Not found contact by");
    }
    try {
      phone = new Phone();
      phone.setContact(contact);
      phone.setNumber(phoneDTO.getNumber());
      phone.setPhoneType(phoneDTO.getPhoneType());
    } catch (Exception e) {
      throw new ServiceException("Error mount data phone {} ", e.getCause());
    }

    return phone;
  }

  public PhoneResponseDTO update(Long id, PhoneRequestDTO phoneDTO) throws ServiceException {
    return PhoneMapper.convertDTO(repository.update(id, PhoneMapper.convertEntity(phoneDTO)));
  }

}
