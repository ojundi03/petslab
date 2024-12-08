package com.petslab.petslab.services;

import com.petslab.petslab.entities.Household;

import java.util.List;

public interface HouseholdService {
    Household createHousehold(Household household);

    void deleteHouseholdById(String eircode);

    Household getHousehold(String  eircode);
    List<Household> getHouseholdsNoPets();

    List<Household> getAllHouseholds();

}
