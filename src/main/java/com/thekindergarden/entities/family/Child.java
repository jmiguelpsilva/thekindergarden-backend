package com.thekindergarden.entities.family;

import com.thekindergarden.entities.shared.Address;
import com.thekindergarden.entities.shared.Auditable;
import jakarta.persistence.*;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "children", schema = "family")
public class Child {
    @Id @GeneratedValue
    private UUID id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "father_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_father")
    )
    private Parent father;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "mother_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_mother")
    )
    private Parent mother;

    @Column(name = "name", length = 100)
    private String fullName;

    @Column(name = "nickname", length = 50)
    private String nickName;

    @Column(name = "vat_number", length = 9, unique = true)
    private String vatNumber;

    @Column(name = "special_needs")
    private Boolean specialNeeds;

    @Column(name = "special_needs_observations", length = 255)
    private String specialNeedsObservations;

    @Embedded
    private Address address;

    @Embedded
    private Auditable auditable;
}
