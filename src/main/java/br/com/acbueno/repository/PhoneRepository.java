package br.com.acbueno.repository;

import java.util.List;
import org.jboss.logging.Logger;
import br.com.acbueno.entity.Phone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PhoneRepository implements PanacheRepository<Phone> {

  @Inject
  Logger logger;

  public List<Phone> getAllPhone() {
    return listAll();
  }

  public Phone getPhoneById(Long id) {
    return findById(id);
  }

  @Transactional
  public void insert(Phone phone) {
    persist(phone);
  }

  @Transactional
  public void deletePhone(String phoneNumber) {
    delete("number", phoneNumber);
  }

  public Phone getPhoneByNumber(String phoneNumber) {
    return find("number", phoneNumber).firstResult();
  }

  @Transactional
  public Phone update(Long id, Phone phone) {
    Phone phoneEntity = null;
    try {
      phoneEntity = findById(id);
      if (phoneEntity == null) {
        throw new NotFoundException("Not found phone id");
      }
      phoneEntity.setNumber(phone.getNumber());
      phoneEntity.setPhoneType(phone.getPhoneType());
      persist(phoneEntity);

    } catch (Exception e) {
      logger.errorf("Error update by id", e.getMessage());
    }
    return phoneEntity;
  }

}
