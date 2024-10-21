package com.example.demo.repository;

import com.example.demo.model.WarhammerCharacter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarhammerCharacterRepository extends JpaRepository<WarhammerCharacter, Long> {
    // findAll() is a method provided by JpaRepository by defualt - no need to add
    // findById() is a method provided by JpaRepository by defualt - no need to add
    List<WarhammerCharacter> findByName(String name);

    // Native query using PostgreSQL SQL syntax
    // @Query(value = "SELECT * FROM users WHERE city = :city AND age > :age", nativeQuery = true)
    // List<User> findByCityAndAgeGreaterThan(@Param("city") String city, @Param("age") int age);
}