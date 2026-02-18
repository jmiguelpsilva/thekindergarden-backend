package com.thekindergarden.dto.family;

import com.thekindergarden.dto.shared.AddressDTO;
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
    private AddressDTO address;
    private ParentDTO father;
    private ParentDTO mother;

    // Optional special needs fields
    private Boolean specialNeeds;
    private String specialNeedsObservations;
}

