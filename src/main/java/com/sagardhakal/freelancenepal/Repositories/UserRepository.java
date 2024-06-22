package com.sagardhakal.freelancenepal.Repositories;

import com.sagardhakal.freelancenepal.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select * from users where email = :email limit 1",nativeQuery = true)
    public Optional<User> getUserWithUsername(@Param("email")String username);

}
