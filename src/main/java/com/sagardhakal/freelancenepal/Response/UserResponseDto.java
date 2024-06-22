package com.sagardhakal.freelancenepal.Response;

import com.sagardhakal.freelancenepal.Models.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String accountType;
    private String skills;
    private String tagLine;
    private String nationality;
    private String description;

    public static UserResponseDto getResponseDto(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .description(user.getDescription())
                .tagLine(user.getTagLine())
                .nationality(user.getNationality())
                .skills(user.getSkills())
                .accountType(user.getAccountType())
                .build();
    }
    public static List<UserResponseDto>getAllResponseDto(List<User>users){
        List<UserResponseDto>userLists=new ArrayList<>();
        for(User user:users){
            userLists.add(getResponseDto(user));
        }
        return userLists;
    }
}
