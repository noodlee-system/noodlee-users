package com.noodleesystem.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.noodleesystem.users.model.UserApiModel;

@Repository
public interface UserRepository extends JpaRepository<UserApiModel, Long>{
    @Async
    @Query("SELECT u FROM UserApiModel u WHERE u.id = :id")
    UserApiModel getUserById(@Param("id") final int id);
}
