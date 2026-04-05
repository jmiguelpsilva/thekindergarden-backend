package com.thekindergarden.controllers.family;

import com.thekindergarden.dto.family.ParentMapper;
import com.thekindergarden.entities.family.Child;
import com.thekindergarden.entities.family.Parent;
import com.thekindergarden.services.family.ChildService;
import com.thekindergarden.services.family.ParentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/parent")
public class ParentController {

    @Inject
    ParentService parentService;

    @Inject
    ChildService childService;

    @GET
    @Path("/vat-number/{vat_number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParentByVatNumber(@PathParam("vat_number") String vatNumber) {
        Optional<Parent> parent = parentService.getParentByVatNumber(vatNumber);

        System.out.println("VAT Number: " + vatNumber);
        System.out.println(parent.toString());

        return parent.map(value -> Response.ok(ParentMapper.INSTANCE.mapParentToParentDTO(value)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/vat-number/{vat_number}/children")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChildrenOfParentByVatNumber(@PathParam("vat_number") String vatNumber) {
        Optional<Parent> parent = parentService.getParentByVatNumber(vatNumber);

        if (parent.isPresent()) {
            Optional<List<Child>> childrenFromParent = childService.getChildrenByParent(parent.get());
        }

        return Response.status(404).entity("No children found for parent with VAT number: " + vatNumber).build();
    }
}
