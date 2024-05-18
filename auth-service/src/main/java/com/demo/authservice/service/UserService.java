package com.demo.authservice.service;

import com.demo.authservice.dtos.UserRegisterRequest;
import com.demo.authservice.model.User;
import com.demo.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public void saveUser(UserRegisterRequest user) {
        User entity = new User();
        entity.setUsername(user.username());
        entity.setPassword(user.password());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        userRepository.save(entity);
    }

}
