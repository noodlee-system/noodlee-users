package com.noodleesystem.users.repository;

import com.noodleesystem.users.model.CourseApiModel;
import com.noodleesystem.users.model.StudentApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseApiModel, Long> {
}
