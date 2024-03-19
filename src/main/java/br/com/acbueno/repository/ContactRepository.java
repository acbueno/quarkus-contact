package br.com.acbueno.repository;

import java.util.List;
import org.jboss.logging.Logger;
import br.com.acbueno.entity.Contact;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ContactRepository implements PanacheRepository<Contact> {

  @Inject
  Logger logger;

  public List<Contact> getAll() {
    return listAll();
  }

  public Contact getContactById(Long id) {
    return findById(id);
  }

  @Transactional
  public boolean deleteById(Long id) {
    Contact entity = findById(id);
    if (entity != null) {
      try {
        delete(entity);
        return true;
      } catch (Exception e) {
        logger.errorf("Error delete id {}", e.getMessage());
      }
    }
    return false;
  }

  @Transactional
  public void insert(Contact contact) {
    persist(contact);
  }

  public Contact getContactByName(String name) {
    return find("name", name).firstResult();
  }

  @Transactional
  public Contact update(Long id, Contact contact) {
    Contact entity = findById(id);
    if (entity != null) {
      entity.setName(contact.getName());
      entity.setAlias(contact.getAlias());
      entity.setPhone(contact.getPhone());
      entity.setAddresses(contact.getAddresses());

      try {
        persist(entity);
      } catch (Exception e) {
        logger.errorf("Error update id {}", e.getMessage());
      }
      return entity;
    } else {
      return null;
    }
  }

}
