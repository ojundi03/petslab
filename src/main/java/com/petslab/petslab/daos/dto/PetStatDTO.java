package com.petslab.petslab.daos.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PetStatDTO {

    private double averageAge;
    private int oldestAge;
    private Long totalCount;

    public PetStatDTO(double averageAge, int oldestAge, Long totalCount) {
        this.averageAge = averageAge;
        this.oldestAge = oldestAge;
        this.totalCount = totalCount;
    }

}