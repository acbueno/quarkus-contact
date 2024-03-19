package br.com.acbueno.service;

import java.util.ArrayList;
import java.util.List;
import br.com.acbueno.entity.Contact;
import br.com.acbueno.repository.ContactRepository;
import br.com.acbueno.service.dto.ContactRequestDTO;
import br.com.acbueno.service.dto.ContactResponseDTO;
import br.com.acbueno.service.mapper.ContactMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ContactService {

  @Inject
  private ContactRepository repository;

  public void insert(ContactRequestDTO dto) {
    repository.insert(ContactMapper.convertEntity(dto));
  }

  public ContactResponseDTO getContactById(Long id) {
    Contact entity = repository.getContactById(id);
    return ContactMapper.convertDTO(entity);
  }

  public List<ContactResponseDTO> getAllContact() {
    List<ContactResponseDTO> listDTO = new ArrayList<>();
    List<Contact> listEntity = repository.getAll();

    listEntity.forEach(it -> {
      listDTO.add(ContactMapper.convertDTO(it));
    });

    return listDTO;
  }

  public ContactResponseDTO update(Long id, ContactRequestDTO dto) {
    return ContactMapper.convertDTO(repository.update(id, ContactMapper.convertEntity(dto)));

  }

  public boolean deleteById(Long id) {
    return repository.deleteById(id);
  }

}
