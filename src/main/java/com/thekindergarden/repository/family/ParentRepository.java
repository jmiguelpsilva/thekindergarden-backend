package com.thekindergarden.repository.family;

import com.thekindergarden.entities.family.Parent;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ParentRepository implements PanacheRepositoryBase<Parent, UUID> {

}
