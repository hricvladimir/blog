package com.vladimirhric.blog.controllers;

import com.vladimirhric.blog.dto.RegisterDto;
import com.vladimirhric.blog.models.Role;
import com.vladimirhric.blog.models.UserEntity;
import com.vladimirhric.blog.repository.RoleRepository;
import com.vladimirhric.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) throws RoleNotFoundException {
        System.out.println("INSIDE");
        if(userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("This username already exists.", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role role = roleRepository.findByName("USER").orElseThrow(() -> new RoleNotFoundException("Role not found"));
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);
        return new ResponseEntity<>("User created successfully.", HttpStatus.OK);
    }



}
