package com.petslab.petslab.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String eircode;

    @Column(nullable = false)
    private String animal_type;

    @Column(nullable = false)
    private String breed;
    @Column(nullable = false)
    private int age;
}
