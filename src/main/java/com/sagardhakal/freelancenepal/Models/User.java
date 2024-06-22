package com.sagardhakal.freelancenepal.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "first_name")
    private String firstName;

    @Column(nullable = false,name = "last_name")
    private String lastName;

    @Column(nullable = false,name = "email",unique = true)
    private String email;

    @Column(nullable = false,name = "password")
    private String password;

    @Column(nullable = false,name = "account_type")
    private String accountType="FREELANCER";

    @Column(name = "minimum_hourly_rate")
    private Double minimumHourlyRate;
    private String skills;

    @Column(name = "tag_line")
    private String tagLine;
    private String nationality;
    @Lob
    private String description;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
