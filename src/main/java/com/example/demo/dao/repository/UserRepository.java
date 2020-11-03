package com.example.demo.dao.repository;

import com.example.demo.dao.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u where u.name = :name")
    UserEntity findByName(@Param("name") String name);
}
