package com.noodleesystem.users.repository;

import com.noodleesystem.users.model.UsersGroupApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersGroupRepository extends JpaRepository<UsersGroupApiModel, Long> {
}
