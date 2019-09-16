package com.noodleesystem.users.repository;

import com.noodleesystem.users.model.StudentApiModel;
import com.noodleesystem.users.model.UserApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentApiModel, Long> {
    @Async
    @Query("SELECT s FROM StudentApiModel s WHERE s.id = :id")
    StudentApiModel getStudentById(@Param("id") final int id);

}
