package com.thekindergarden.services.family;

import com.thekindergarden.entities.family.Parent;
import com.thekindergarden.repository.family.ParentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class ParentService {

    @Inject
    ParentRepository parentRepository;

    @Transactional
    public Parent addParent(Parent parent) {
        parentRepository.persist(parent);
        return parent;
    }

    public Optional<Parent> getParentByVatNumber(String vatNumber) {
        return Optional.ofNullable(parentRepository.find("vatNumber", vatNumber).firstResult());
    }
}
