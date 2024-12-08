package com.petslab.petslab;


import com.petslab.petslab.daos.HouseholdRepository;
import com.petslab.petslab.daos.MyUserRepository;
import com.petslab.petslab.daos.PetRepository;
import com.petslab.petslab.entities.MyUser;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private PetRepository petRepository;
    private HouseholdRepository householdRepository;
    private MyUserRepository myUserRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        myUserRepository.save(new MyUser("test@email.com", passwordEncoder.encode("password123"),
                "john","doe","Cork","ROLE_ADMIN",true,true,true,true ));
    }

}
