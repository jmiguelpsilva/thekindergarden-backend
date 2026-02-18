package com.thekindergarden.factory.family;

import com.thekindergarden.dto.family.ChildDTO;
import com.thekindergarden.dto.family.ParentDTO;
import com.thekindergarden.entities.family.Child;
import com.thekindergarden.entities.family.Parent;
import com.thekindergarden.entities.shared.Address;
import com.thekindergarden.entities.shared.Auditable;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Timestamp;
import java.time.Instant;

@ApplicationScoped
public class ChildFactory {

    public Child create(ChildDTO dto) {
        return Child.builder()
                .fullName(dto.getFullName())
                .nickName(dto.getNickName())
                .vatNumber(dto.getVatNumber())
                .address(createAddress(dto))
                .father(createParent(dto.getFather()))
                .mother(createParent(dto.getMother()))
                .specialNeeds(dto.getSpecialNeeds())
                .specialNeedsObservations(dto.getSpecialNeedsObservations())
                .auditable(createAuditable())
                .build();
    }

    private Address createAddress(ChildDTO dto) {
        if (dto.getAddress() == null) {
            return null;
        }
        return Address.builder()
                .street(dto.getAddress().getStreet())
                .city(dto.getAddress().getCity())
                .postalCode(dto.getAddress().getPostalCode())
                .country(dto.getAddress().getCountry())
                .build();
    }

    private Parent createParent(ParentDTO dto) {
        if (dto == null) {
            return null;
        }
        return Parent.builder()
                .fullName(dto.getFullName())
                .build();
    }

    private Auditable createAuditable() {
        Timestamp now = Timestamp.from(Instant.now());
        return Auditable.builder()
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
