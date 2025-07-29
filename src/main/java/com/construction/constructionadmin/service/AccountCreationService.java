package com.construction.constructionadmin.service;

import com.construction.constructionadmin.dto.AccountCreationDTO;
import com.construction.constructionadmin.entity.AccountCreation;
import com.construction.constructionadmin.repository.ConstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountCreationService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final ConstructionRepository repository;

    public AccountCreationService(ConstructionRepository repository) {
        this.repository = repository;
    }

    public AccountCreation saveAccountCreation(AccountCreationDTO accountCreationDTO) {
        if(repository.findByEmail(accountCreationDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        AccountCreation entity = new AccountCreation();

        entity.setName(accountCreationDTO.getName());
        entity.setEmail(accountCreationDTO.getEmail());
        entity.setPassword(passwordEncoder.encode(accountCreationDTO.getPassword()));
        entity.setPhoneNumber(accountCreationDTO.getPhoneNumber());
        entity.setAddress(accountCreationDTO.getAddress());
        return repository.save(entity);
    }

    public String loginUser(AccountCreationDTO dto) {
        Optional<AccountCreation> userOpt = repository.findByEmail(dto.getEmail());
        if (userOpt.isEmpty()) return "User not found";

        AccountCreation user = userOpt.get();
        if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return "Login successful. Welcome, " + user.getEmail();
        } else {
            return "Invalid password";
        }
    }
}
