package com.thekindergarden.repository;

import com.thekindergarden.entities.family.Child;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ChildRepository implements PanacheRepositoryBase<Child, UUID> {

}
