package com.thekindergarden.dto.shared;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDTO {
    private String street;
    private String city;
    private String postalCode;
    private String country;
}

