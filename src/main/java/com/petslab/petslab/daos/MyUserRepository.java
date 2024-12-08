package com.petslab.petslab.daos;

import com.petslab.petslab.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, String> {

}
