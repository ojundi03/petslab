package com.petslab.petslab.security;


import com.petslab.petslab.daos.MyUserRepository;
import com.petslab.petslab.entities.MyUser;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class  MyUserDetailsService implements UserDetailsService {
    private MyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new User(user.getEmail(), user.getPassword(),user.isEnabled(),
                user.isAccountNonExpired(),user.isCredentialsNonExpired(), user.isAccountNonLocked(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }

}
