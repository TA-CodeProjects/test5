package com.jb.test5.services;


import com.jb.test5.beans.Student;
import com.jb.test5.exceptions.SchoolSystemException;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);
    void deleteStudent(long id) throws SchoolSystemException;
    List<Student> getAllStudents();
    Student getOneStudent(long id) throws SchoolSystemException;
    List<Student> getStudentsByName(String name);
    double avgStudentGrades(long id);
}
