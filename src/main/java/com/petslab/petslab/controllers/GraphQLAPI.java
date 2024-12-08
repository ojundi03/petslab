package com.petslab.petslab.controllers;


import com.petslab.petslab.entities.Household;
import com.petslab.petslab.entities.Pet;
import com.petslab.petslab.services.HouseholdService;
import com.petslab.petslab.services.PetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLAPI {
    private PetService petService;
    private HouseholdService householdService;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @QueryMapping
    List<Household> findAllHouseholds(){return householdService.getAllHouseholds();}

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @QueryMapping
    List<Pet> findAllPetsByType(@Argument String type){return petService.getPetsByType(type);}

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @QueryMapping
    Household findHouseholdById(@Argument String eircode){return householdService.getHousehold(eircode);}

    @Secured("ROLE_USER")
    @QueryMapping
    Pet findPetById(@Argument int id){return petService.getPetById(id);}

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @QueryMapping List<Pet> findAll(){return petService.getAllPets();}

    @Secured("ROLE_ADMIN")
    @MutationMapping
    void deleteHousehold(@Argument String eircode) throws ChangeSetPersister.NotFoundException {
        householdService.deleteHouseholdById(eircode);
    }

    @Secured("ROLE_ADMIN")
    @MutationMapping
    void deletePet(@Argument int id) throws ChangeSetPersister.NotFoundException {
        petService.deletePetById(id);
    }


    @Secured("ROLE_ADMIN")
    @MutationMapping
    Household createHousehold(@Valid @Argument("household") Household newHousehold) throws ChangeSetPersister.NotFoundException {
        String eircode = newHousehold.getEircode();
        return householdService.createHousehold(newHousehold);
    }
}
