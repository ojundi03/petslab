package com.petslab.petslab.daos;

import com.petslab.petslab.entities.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household, String> {

    @Query("SELECT h from Household h WHERE h.eircode = :eircode")
    public Household findHouseholdByEircode(String eircode);


    @Query("SELECT h FROM Household h WHERE NOT EXISTS (SELECT p FROM Pet p WHERE p.eircode = h.eircode)")
    List<Household> findHouseholdNoPets();
}
