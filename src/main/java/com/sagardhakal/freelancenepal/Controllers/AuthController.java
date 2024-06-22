package com.sagardhakal.freelancenepal.Controllers;

import com.sagardhakal.freelancenepal.Helper.ResponseHelper;
import com.sagardhakal.freelancenepal.Models.User;
import com.sagardhakal.freelancenepal.Request.UserLoginRequest;
import com.sagardhakal.freelancenepal.Request.UserRegisterRequest;
import com.sagardhakal.freelancenepal.Response.UserResponseDto;
import com.sagardhakal.freelancenepal.Services.JwtService;
import com.sagardhakal.freelancenepal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegisterRequest userRegisterRequest){
        try {
            if(userRegisterRequest.getEmail()==null ||
                userRegisterRequest.getFirstName()==null||
                    userRegisterRequest.getLastName()==null||
                    userRegisterRequest.getPassword()==null
            ){
                throw new Exception("Some Fields Are Missing");
            }
            User user=userService.createNewUser(userRegisterRequest);
            return  ResponseHelper.getResponse(200,"User Registered Successfully", UserResponseDto.getResponseDto(user));
        }catch (Exception e){
            return  ResponseHelper.getResponse(400,e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequest userLoginRequest){
        try {
            User user=authenticate(userLoginRequest);
            System.out.println(user);
            String token=jwtService.generateToken(user);
            HashMap<String,String> tokenResponse=new HashMap<>();
            tokenResponse.put("token",token);
            return  ResponseHelper.getResponse(200,"User Registered Successfully",tokenResponse);
        }catch (Exception e){
            return  ResponseHelper.getResponse(400,e.getMessage());
        }
    }

    public User authenticate(UserLoginRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return (User) userService.loadUserByUsername(input.getEmail());
    }
}
