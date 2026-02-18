package com.thekindergarden.dto.family;

import com.thekindergarden.entities.family.Parent;
import org.mapstruct.Mapper;

@Mapper
public interface ParentMapper {

    ParentMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ParentMapper.class);

    ParentDTO mapParentToParentDTO(Parent parent);

    Parent mapParentDTOToParent(ParentDTO parentDTO);

    ParentDTO clone(ParentDTO source);
}
