package com.petslab.petslab.services;

import com.petslab.petslab.entities.Household;

import java.util.List;

public interface HouseholdService {
    Household getHousehold(String  eircode);
    List<Household> findHouseholdNoPets();
}
