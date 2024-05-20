package com.demo.authservice.service.concrete;

import com.demo.authservice.dtos.UserRegisterRequest;
import com.demo.authservice.model.User;
import com.demo.authservice.repository.UserRepository;
import com.demo.authservice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserRegisterRequest user) {
        User newUser = User.builder()
                .username(user.username())
                .name(user.name())
                .email(user.email())
                .password(passwordEncoder.encode(user.password()))
                .authorities(user.authorities())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .isEnabled(true)
                .credentialsNonExpired(true)
                .build();
        userRepository.save(newUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
