package com.petslab.petslab.services;

import com.petslab.petslab.daos.dto.PetStatDTO;
import com.petslab.petslab.entities.Pet;

import java.util.List;

public interface PetService {
    Pet createPet(Pet pet);
    List<Pet> getAllPets();
    Pet getPetById(int id);
    void updatePet(int id, Pet newPetData);
    void deletePetById(int id);
    void deletePetsByName(String name);
    List<Pet> getPetsByType(String type);
    List<Pet> getPetsByBreed(String breed);
    PetStatDTO getPetStats();


}
