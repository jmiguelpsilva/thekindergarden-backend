package com.thekindergarden.dto.family;

import com.thekindergarden.entities.shared.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParentDTO {
    private String fullName;
    private String vatNumber;
    private Address address;

}

