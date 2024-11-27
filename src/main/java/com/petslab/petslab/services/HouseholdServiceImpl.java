package com.petslab.petslab.services;

import com.petslab.petslab.daos.HouseholdRepository;
import com.petslab.petslab.entities.Household;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseholdServiceImpl implements  HouseholdService {
    private final HouseholdRepository householdRepository;

    @Override
    public Household getHousehold(String eircode){
        return householdRepository.findHouseholdByEircode(eircode);
    }

    @Override
    public List<Household> findHouseholdNoPets(){
        return householdRepository.findHouseholdNoPets();
    }
}
