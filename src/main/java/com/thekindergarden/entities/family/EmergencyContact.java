package com.thekindergarden.entities.family;

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
@Table(name = "emergency_contacts", schema = "family")
public class EmergencyContact {

    @Id @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "child_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_sos_contact_child")
    )

    private Child child;
    private String name;
    private String phoneNumber;
    private String observations;
}
