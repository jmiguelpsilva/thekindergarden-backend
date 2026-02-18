package com.thekindergarden.dto.family;

import com.thekindergarden.entities.family.Child;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChildMapper {

    public static ChildMapper INSTANCE = Mappers.getMapper(ChildMapper.class);

    public ChildDTO mapChildToChildDTO(Child child);

    public Child mapChildDTOToChild(ChildDTO childDTO);

    public ChildDTO clone(ChildDTO source);
}
