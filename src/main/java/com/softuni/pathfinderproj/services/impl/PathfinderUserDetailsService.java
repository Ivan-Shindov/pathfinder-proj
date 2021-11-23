package com.softuni.pathfinderproj.services.impl;

import com.softuni.pathfinderproj.models.entity.UserEntity;
import com.softuni.pathfinderproj.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PathfinderUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public PathfinderUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + " was not found"));


        return map(userEntity);
    }

    private UserDetails map(UserEntity user) {
        Set<GrantedAuthority> authorities = user.getRole()
                .stream()
                .map(roleEntity -> new SimpleGrantedAuthority("ROLE_" + roleEntity.getRole()))
                .collect(Collectors.toSet());

        return new User(
          user.getEmail(),
          user.getPassword(),
          authorities
        );
    }
}
