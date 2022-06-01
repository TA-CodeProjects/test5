package com.jb.test5.services;

import com.jb.test5.beans.Student;
import com.jb.test5.exceptions.ErrorMessage;
import com.jb.test5.exceptions.SchoolSystemException;
import com.jb.test5.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) throws SchoolSystemException {
        if (!studentRepository.existsById(id)){
            throw new SchoolSystemException(ErrorMessage.ID_NOT_FOUND);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getOneStudent(long id) throws SchoolSystemException {
      return studentRepository.findById(id).orElseThrow(()-> new SchoolSystemException(ErrorMessage.ID_NOT_FOUND));
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public double avgStudentGrades(long id) {
        return studentRepository.avgStudentGrades(id);
    }
}
