package com.devsuperior.userdpt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsuperior.userdpt.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);

   @Query(value="SELECT * FROM TB_USER u WHERE u.name = :name and u.email= :email", nativeQuery = true)
   Optional<User> findByNameAndEmail(
        @Param("name") String name, 
        @Param("email") String email);
    
}
