package com.petslab.petslab.daos;

import com.petslab.petslab.daos.dto.PetStatDTO;
import com.petslab.petslab.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query("SELECT p FROM Pet p WHERE p.id = :id")
    Pet findPetById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Pet p SET p.name = :name, p.eircode = :eircode,p.animal_type = :type, p.breed = :breed, p.age = :age WHERE p.id = :id")
    int updatePetById(int id, String name,String eircode, String type, String breed, int age);

    @Transactional
    @Modifying
    @Query("UPDATE Pet p SET p.name = :name WHERE p.id = :id")
    int updatePetName(String name, int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Pet p WHERE p.id = :id")
    int deletePetById(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Pet p WHERE LOWER(p.name) = LOWER(:name)")
    int deletePetsByName(String name);

    @Query("SELECT p FROM Pet p WHERE p.animal_type = :animalType")
    List<Pet> getPetsByType(String animalType);

    @Query("SELECT p FROM Pet p WHERE p.breed = :breed ORDER BY p.age ASC")
    List<Pet> getPetsByBreed(String breed);

    @Query("SELECT new com.petslab.petslab.daos.dto.PetStatDTO(AVG(p.age),MAX(p.age),COUNT(p)) FROM Pet p")
    PetStatDTO getPetStats();

}
