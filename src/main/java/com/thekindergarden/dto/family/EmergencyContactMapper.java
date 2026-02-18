package com.thekindergarden.dto.family;

import com.thekindergarden.entities.family.EmergencyContact;
import org.mapstruct.Mapper;

@Mapper
public interface EmergencyContactMapper {

    EmergencyContactMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(EmergencyContactMapper.class);

    EmergencyContactDTO mapEmergencyContactToEmergencyContactDTO(EmergencyContact emergencyContact);

    EmergencyContact mapEmergencyContactDTOToEmergencyContact(EmergencyContactDTO emergencyContactDTO);

    EmergencyContactDTO clone(EmergencyContactDTO source);
}
