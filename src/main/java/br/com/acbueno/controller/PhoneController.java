package br.com.acbueno.controller;

import br.com.acbueno.exception.ServiceException;
import br.com.acbueno.service.PhoneService;
import br.com.acbueno.service.dto.PhoneRequestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.java.Log;

@Path("/api/v1/phone")
@Log
public class PhoneController {

  @Inject
  private PhoneService service;

  @GET
  @Path("/{idPhone}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPhoneById(@PathParam("idPhone") Long id) {
    return Response.ok(service.getPhoneById(id)).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPhone() {
    return Response.ok(service.getPhoneAll()).build();
  }

  @POST
  @Path("/{idContact}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response save(@PathParam("idContact") Long id, PhoneRequestDTO dto) {
    try {
      service.save(id,dto);
      return Response.ok().build();
    } catch (Exception e) {
      log.severe(e.getMessage());
      return Response.serverError().build();
    }
  }

  @PUT
  @Path("/{idPhone}")
  public Response update(@PathParam("idPhone") Long id, PhoneRequestDTO dto) throws ServiceException {
    return Response.ok().entity(service.update(id, dto)).build();
  }

  @DELETE
  @Path("/{idPhone}")
  public Response delete(@PathParam("idPhone") Long id) {
    try {
      service.deletePhoneById(id);
      return Response.ok().build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

}
