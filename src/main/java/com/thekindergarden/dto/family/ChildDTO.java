package com.thekindergarden.dto.family;

import com.thekindergarden.entities.shared.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChildDTO {
    private String fullName;
    private String nickName;
    private String vatNumber;
    private Address address;
    private ParentDTO father;
    private ParentDTO mother;

    // Optional special needs fields
    private Boolean specialNeeds;
    private String specialNeedsObservations;
}

