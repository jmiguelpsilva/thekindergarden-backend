package com.thekindergarden.entities.family;

import com.thekindergarden.entities.shared.Address;
import com.thekindergarden.entities.shared.Auditable;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "parents", schema = "family")
public class Parent extends PanacheEntityBase {
    @Id @GeneratedValue
    private UUID id;

    @Column(name = "name", length = 100)
    private String fullName;

    @Column(name = "vat_number", length = 9, unique = true)
    String vatNumber;

    @Embedded
    Address address;

    @Embedded
    Auditable auditable;
}
