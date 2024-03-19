package br.com.acbueno.service.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.acbueno.service.client.dto.ZipCodeDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("ws")
@RegisterRestClient(configKey = "zipcode-api")
public interface ZipCodeService {


  @GET
  @Path("{cep}/json")
  public ZipCodeDTO getAddressByZipCode(@PathParam("cep") int cep);


}
