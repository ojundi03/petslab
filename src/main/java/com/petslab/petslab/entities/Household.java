package com.petslab.petslab.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Household {
    @Id
    private String eircode;

    @Column(nullable = false)
    private int number_of_occupants;

    @Column(nullable = false)
    private int maxNumberOfOccupants;

    @Column(nullable = false)
    private boolean ownerOccupied;
}
