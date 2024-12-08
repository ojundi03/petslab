package com.petslab.petslab.services;

//import com.petslab.petslab.daos.dto.PetStatDTO;
import com.petslab.petslab.daos.dto.PetStatDTO;
import com.petslab.petslab.entities.Pet;
import org.springframework.stereotype.Service;
import com.petslab.petslab.daos.PetRepository;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(int id) {
        return petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @Override
    public void updatePet(int id, Pet petDetails) {
        petRepository.updatePetById(
                id,
                petDetails.getName(),
                petDetails.getEircode(),
                petDetails.getAnimal_type(),
                petDetails.getBreed(),
                petDetails.getAge()
        );
    };

    @Override
    public void updatePetName(int id, String name){
        petRepository.updatePetName(name, id);
    }

    @Override
    public void deletePetById(int id) {
        Pet pet = getPetById(id);
        petRepository.delete(pet);
    }


    @Override
    public void deletePetsByName(String name) {
        petRepository.deletePetsByName(name);
    }

    public List<Pet> getPetsByType(String type){
        return petRepository.getPetsByType(type);
    }

    public List<Pet> getPetsByBreed(String breed){
        return petRepository.getPetsByBreed(breed);
    }

    @Override
    public PetStatDTO getPetStats() {
        return petRepository.getPetStats();
    }
}
