package com.sagardhakal.freelancenepal.Services;

import com.sagardhakal.freelancenepal.Models.User;
import com.sagardhakal.freelancenepal.Repositories.UserRepository;
import com.sagardhakal.freelancenepal.Request.UserRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>optionalUser=userRepository.getUserWithUsername(username);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new UsernameNotFoundException("No User Found For Given Email Address");
    }

    public User createNewUser(UserRegisterRequest userRegisterRequest) throws Exception{
        Optional<User>optionalUser=userRepository.getUserWithUsername(userRegisterRequest.getEmail());
        if(optionalUser.isPresent()){
            throw new Exception("User Already Exists For Given Email Address");
        }
        String password=passwordEncoder.encode(userRegisterRequest.getPassword());
        User user=User.builder()
                .firstName(userRegisterRequest.getFirstName())
                .lastName(userRegisterRequest.getLastName())
                .email(userRegisterRequest.getEmail())
                .password(password)
                .accountType(userRegisterRequest.getAccountType())
                .build();
        return userRepository.save(user);
    }
}
