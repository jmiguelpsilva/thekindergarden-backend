package com.thekindergarden.factory.family;

import com.thekindergarden.dto.family.ChildDTO;
import com.thekindergarden.dto.family.ParentDTO;
import com.thekindergarden.entities.family.Child;
import com.thekindergarden.entities.family.Parent;
import com.thekindergarden.services.family.ParentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class FamilyFactory {

    @Inject
    SharedFactory sharedFactory;

    @Inject
    ParentService parentService;

    public Child create(ChildDTO dto) {
        return Child.builder()
                .fullName(dto.getFullName())
                .nickName(dto.getNickName())
                .vatNumber(dto.getVatNumber())
                .address(sharedFactory.create(dto.getAddress()))
                .father(setParent(dto.getFather()))
                .mother(setParent(dto.getMother()))
                .specialNeeds(dto.getSpecialNeeds())
                .specialNeedsObservations(dto.getSpecialNeedsObservations())
                .auditable(sharedFactory.createAuditable())
                .build();
    }

    public Parent create(ParentDTO dto) {
        Parent newParent = Parent.builder()
                .fullName(dto.getFullName())
                .vatNumber(dto.getVatNumber())
                .build();

        return parentService.addParent(newParent);
    }

    private Parent setParent(ParentDTO dto) {
        Optional<Parent> parent = parentService.getParentByVatNumber(dto.getVatNumber());

        return parent.isPresent() ? parent.get() : create(dto);
    }


}
