package br.com.acbueno.controller;

import br.com.acbueno.service.ContactService;
import br.com.acbueno.service.dto.ContactRequestDTO;
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

@Path("/api/v1/contact")
public class ContactController {

  @Inject
  ContactService service;

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getContactById(@PathParam("id") Long id) {
    return Response.ok(service.getContactById(id)).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllContact() {
    return Response.ok(service.getAllContact()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response save(ContactRequestDTO dto) {
    try {
      service.insert(dto);
      return Response.ok().build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response update(@PathParam("id") Long id, ContactRequestDTO dto) {
    try {
        return Response.ok(service.update(id, dto)).build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @DELETE
  @Path("/{id}")
  public Response deleteById(@PathParam("id") Long id) {
    try {
       service.deleteById(id);
       return Response.ok().build();
    } catch (Exception e) {
       return Response.serverError().build();
    }
  }

}
