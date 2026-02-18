package com.thekindergarden.dto.shared;

import com.thekindergarden.entities.shared.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {

    public static AddressMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(AddressMapper.class);

    public AddressDTO mapAddressToAddressDTO(Address address);

    public Address mapAddressDTOToAddress(AddressDTO addressDTO);

    public AddressDTO clone(AddressDTO source);
}
