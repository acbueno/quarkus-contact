package br.com.acbueno.repository;

import java.util.List;
import org.jboss.logging.Logger;
import br.com.acbueno.entity.Address;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class AddressRepository implements PanacheRepository<Address> {

  @Inject
  Logger logger;

  public List<Address> getlAllAddress() {
    return listAll();
  }

  public Address getAddressById(Long id) {
    return findById(id);
  }

  @Transactional
  public boolean deleteById(Long id) {
    try {
      Address address = findById(id);
      delete(address);
      return true;
    } catch (Exception e) {
      logger.errorf("Error delete by id", e.getMessage());
    }
    return false;
  }

  @Transactional
  public void insert(Address address) {
    persist(address);
  }

  @Transactional
  public Address updateAddress(Long id, Address address) {
    Address addressEntity = null;
    addressEntity = findById(id);

    if (addressEntity == null) {
      throw new NotFoundException("Not found address by");
    }
    try {
      addressEntity.setCity(address.getCity());
      addressEntity.setNeighborhood(address.getNeighborhood());
      addressEntity.setNote(address.getNote());
      addressEntity.setNumber(address.getNumber());
      addressEntity.setZipCode(address.getZipCode());
      persist(addressEntity);
    } catch (Exception e) {
      logger.errorf("Error update by id", e.getMessage());
    }
    return addressEntity;
  }

}
