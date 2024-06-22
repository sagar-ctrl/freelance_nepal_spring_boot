package com.sagardhakal.freelancenepal.Controllers;

import com.sagardhakal.freelancenepal.Helper.ResponseHelper;
import com.sagardhakal.freelancenepal.Models.User;
import com.sagardhakal.freelancenepal.Response.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @GetMapping("/me")
    public ResponseEntity me(){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseHelper.getResponse(200,"User Data Fetched Successfully", UserResponseDto.getResponseDto(user));
    }
}
