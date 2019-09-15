package com.noodleesystem.users.repository;

import com.noodleesystem.users.model.ScoreApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreApiModel, Long> {
}
