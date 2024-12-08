package com.petslab.petslab.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "myuser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    @Id
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String county;
    private String role;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;
}
