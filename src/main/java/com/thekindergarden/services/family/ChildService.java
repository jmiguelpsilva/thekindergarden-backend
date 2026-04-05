package com.thekindergarden.services.family;

import com.thekindergarden.dto.family.ChildDTO;
import com.thekindergarden.entities.family.Child;
import com.thekindergarden.entities.family.Parent;
import com.thekindergarden.factory.family.FamilyFactory;
import com.thekindergarden.repository.family.ChildRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ChildService {

    @Inject
    ChildRepository childRepository;

    @Inject
    FamilyFactory familyFactory;

    public Optional<Child> getChildByVatNumber(String vatNumber) {
        return Optional.ofNullable(childRepository.find("vatNumber", vatNumber).firstResult());
    }

    @Transactional
    public Optional<Child> addChild(ChildDTO newChildDTO) {
        return Optional.ofNullable(familyFactory.create(newChildDTO))
                .map(child -> {
                    childRepository.persist(child);
                    return child;
                });
    }

    public List<Child> getAllChildren() {
        return childRepository.listAll();
    }

    public Optional<List<Child>> getChildrenByParent(Parent parent){
        return Optional.ofNullable(childRepository.find("father = ?1 or mother = ?1", parent).list());
    }
}