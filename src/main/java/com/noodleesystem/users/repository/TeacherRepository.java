package com.noodleesystem.users.repository;

import com.noodleesystem.users.model.TeacherApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherApiModel, Long> {
}
