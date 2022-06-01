package com.jb.test5.repos;

import com.jb.test5.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByName(String name);
    @Query(value = "select avg (score) from spring.grades where student_id = ?;", nativeQuery = true)
    double avgStudentGrades(long id);
}
