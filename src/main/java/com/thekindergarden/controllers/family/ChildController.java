package com.thekindergarden.controllers.family;

import com.thekindergarden.dto.family.ChildDTO;
import com.thekindergarden.dto.family.ChildMapper;
import com.thekindergarden.entities.family.Child;
import com.thekindergarden.repository.family.ChildRepository;
import com.thekindergarden.services.family.ChildService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/child")
public class ChildController {

    @Inject
    ChildRepository childRepository;
    @Inject
    ChildService childService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllChildren() {
        List<Child> children = childService.getAllChildren();
        if (children.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(children.stream().map(ChildMapper.INSTANCE::mapChildToChildDTO).toList())
                .build();
    }

    @GET
    @Path("/vat-number/{vat_number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChildByVatNumber(@PathParam("vat_number") String vatNumber) {
        Optional<Child> child = childService.getChildByVatNumber(vatNumber);

        return child.map(value -> Response.ok(ChildMapper.INSTANCE.mapChildToChildDTO(value)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addChild(ChildDTO childDTO) {

        Optional<Child> newChild = childService.getChildByVatNumber(childDTO.getVatNumber());

        if (newChild.isEmpty()) {
            newChild = childService.addChild(childDTO);

            return newChild.map(child -> Response.status(201)
                            .entity(ChildMapper.INSTANCE.mapChildToChildDTO(child))
                            .build())
                    .orElse(Response.status(Response.Status.BAD_REQUEST).build());
        } else
            return Response.noContent().entity(newChild.get()).build();
    }



}
