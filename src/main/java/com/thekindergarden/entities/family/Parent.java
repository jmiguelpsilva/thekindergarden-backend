package com.thekindergarden.entities.family;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "parents", schema = "family")
public class Parent extends PanacheEntityBase {
    @Id @GeneratedValue
    private UUID id;

    private String fullName;

    @OneToMany(mappedBy = "father")
    private List<Child> children;
}
