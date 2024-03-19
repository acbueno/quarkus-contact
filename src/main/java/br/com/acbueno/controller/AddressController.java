package br.com.acbueno.controller;

import br.com.acbueno.service.AddressService;
import br.com.acbueno.service.dto.AddressRequestDTO;
import br.com.acbueno.service.dto.AddressResponseDTO;
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

@Path("/api/v1/address")
public class AddressController {

  @Inject
  private AddressService service;

  @GET
  @Path("/{idAddress}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAddressById(@PathParam("idAddress") Long id) {
    return Response.ok(service.getAddressById(id)).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllAdresses() {
    return Response.ok(service.listAllAddress()).build();
  }

  @POST
  @Path("/{idContact}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response save(@PathParam("idContact") Long id, AddressRequestDTO dto) {
    try {
      service.insert(id, dto);
      return Response.ok().build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @PUT
  @Path("/{idAddress}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response update(@PathParam("idAddress") Long id, AddressRequestDTO dto) {
    try {
      return Response.ok(service.update(id, dto)).build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @DELETE
  @Path("/{idAddress}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteAddressById(@PathParam("idAddress") Long id) {
    try {
      service.deleteAddressById(id);
      return Response.ok().build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

}
