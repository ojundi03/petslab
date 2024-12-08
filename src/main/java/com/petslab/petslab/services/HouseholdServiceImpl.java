package com.petslab.petslab.services;

import com.petslab.petslab.daos.HouseholdRepository;
import com.petslab.petslab.daos.PetRepository;
import com.petslab.petslab.entities.Household;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseholdServiceImpl implements  HouseholdService {
    private final HouseholdRepository householdRepository;
    private final PetRepository petRepository;

    @Override
    public Household getHousehold(String eircode){
        return householdRepository.findHouseholdByEircode(eircode);
    }

    @Override
    public List<Household> getHouseholdsNoPets(){
        return householdRepository.getHouseholdsNoPets();
    }

    @Override
    public List<Household> getAllHouseholds(){
        return householdRepository.getAllHouseholds();
    }

    @Override
    public Household createHousehold(Household household){
        return householdRepository.save(household);
    }

    @Override
    public void deleteHouseholdById(String eircode){
        householdRepository.deleteById(eircode);
    }


}
