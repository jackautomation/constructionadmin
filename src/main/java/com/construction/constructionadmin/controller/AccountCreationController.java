package com.construction.constructionadmin.controller;

import com.construction.constructionadmin.dto.AccountCreationDTO;
import com.construction.constructionadmin.entity.AccountCreation;
import com.construction.constructionadmin.service.AccountCreationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AccountCreationController {

    private final AccountCreationService service;
    public AccountCreationController(AccountCreationService service) {
        this.service = service;
    }

    @PostMapping("/account-creation")
    public String createAccount(@RequestBody AccountCreationDTO accountCreation) {
        AccountCreation accountCreationEntity = service.saveAccountCreation(accountCreation);
        System.out.println("Account Id "+accountCreation.getId());
        System.out.println("Account Name "+accountCreation.getName());
        System.out.println("Account email Id "+accountCreation.getEmail());
        System.out.println("Account password "+accountCreation.getPassword());
        System.out.println("Account phonenumber "+accountCreation.getPhoneNumber());
        System.out.println("Account address "+accountCreation.getAddress());
        return "Account created successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody AccountCreationDTO accountCreation) {
        service.loginUser(accountCreation);
        return "Login successful";
    }
}
