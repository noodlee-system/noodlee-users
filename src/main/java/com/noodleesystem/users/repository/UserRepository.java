package com.noodleesystem.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noodleesystem.users.model.UserApiModel;

@Repository
public interface UserRepository extends JpaRepository<UserApiModel, Long>{ }
