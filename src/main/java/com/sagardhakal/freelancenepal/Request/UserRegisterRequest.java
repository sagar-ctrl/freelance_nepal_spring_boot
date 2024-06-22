package com.sagardhakal.freelancenepal.Request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String accountType;
}
