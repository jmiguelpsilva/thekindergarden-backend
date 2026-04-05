package com.thekindergarden.factory.family;

import com.thekindergarden.dto.shared.AddressDTO;
import com.thekindergarden.entities.shared.Address;
import com.thekindergarden.entities.shared.Auditable;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Timestamp;
import java.time.Instant;

@ApplicationScoped
public class SharedFactory {

    public Address create(AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        return Address.builder()
                .street(dto.getStreet())
                .city(dto.getCity())
                .postalCode(dto.getPostalCode())
                .country(dto.getCountry())
                .build();
    }

    protected Auditable createAuditable() {
        Timestamp now = Timestamp.from(Instant.now());
        return Auditable.builder()
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
