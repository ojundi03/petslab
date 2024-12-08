package com.petslab.petslab.controllers;

import com.petslab.petslab.entities.Household;
import com.petslab.petslab.services.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/household")
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

//    @GetMapping
//    public ResponseEntity<List<Household>> getAllHouseholds() {
//        return ResponseEntity.ok(householdService.getAllHouseholds());
//    }

    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHousehold(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHousehold(eircode));
    }

    @GetMapping
    public ResponseEntity<List<Household>> getHouseholdsNoPets(){
        return ResponseEntity.ok(householdService.getHouseholdsNoPets());
    }
    @PostMapping
    public ResponseEntity<Household> createHousehold(@Valid @RequestBody Household household) {
        return ResponseEntity.status(HttpStatus.CREATED).body(householdService.createHousehold(household));
    }

    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHouseholdById(@PathVariable String eircode) {
        householdService.deleteHouseholdById(eircode);
        return ResponseEntity.noContent().build();
    }


}
