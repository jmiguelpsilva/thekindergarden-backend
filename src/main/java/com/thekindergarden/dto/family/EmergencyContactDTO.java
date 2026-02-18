package com.thekindergarden.dto.family;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmergencyContactDTO {
    private String name;
    private String phoneNumber;
    private String observations;
}

