package com.construction.constructionadmin.dto;

public class JwtResponse {

    public String token;
    public String email;

    public JwtResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }
}
