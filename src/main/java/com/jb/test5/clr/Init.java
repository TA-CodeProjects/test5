package com.jb.test5.clr;

import com.jb.test5.beans.Grade;
import com.jb.test5.beans.Student;
import com.jb.test5.beans.Topic;
import com.jb.test5.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(1)
@RequiredArgsConstructor
public class Init implements CommandLineRunner {
    private final StudentService studentService;

    @Override
    public void run(String... args) throws Exception {

        Grade grade1 = new Grade(Topic.PROJECTS1, 90);
        Grade grade2 = new Grade(Topic.PROJECTS2, 80);
        Grade grade3 = new Grade(Topic.PROJECTS3, 100);
        Grade grade4 = new Grade(Topic.PROJECTS1, 60);
        Grade grade5 = new Grade(Topic.PROJECTS2, 80);
        Grade grade6 = new Grade(Topic.PROJECTS3, 70);
        Grade grade7 = new Grade(Topic.PROJECTS1, 70);
        Grade grade8 = new Grade(Topic.PROJECTS2, 70);
        Grade grade9 = new Grade(Topic.PROJECTS3, 70);

        Student student1 = Student.builder().name("Moshe")
                .birthday(Date.valueOf(LocalDate.of(2000, 4,21)))
                .isActive(true)
                .grade(grade1)
                .grade(grade2)
                .grade(grade3)
                .build();

        Student student2 = Student.builder().name("Dan")
                .birthday(Date.valueOf(LocalDate.of(2001, 2,11)))
                .isActive(true)
                .grade(grade4)
                .grade(grade5)
                .grade(grade6)
                .build();

        Student student3 = Student.builder().name("Dana")
                .birthday(Date.valueOf(LocalDate.of(2001, 2,11)))
                .isActive(true)
                .grade(grade7)
                .grade(grade8)
                .grade(grade9)
                .build();

        grade1.setStudent(student1);
        grade2.setStudent(student1);
        grade3.setStudent(student1);
        grade4.setStudent(student2);
        grade5.setStudent(student2);
        grade6.setStudent(student2);
        grade7.setStudent(student3);
        grade8.setStudent(student3);
        grade9.setStudent(student3);



        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@ Add Student @@@@@@@@@@@@@@@");

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);

        printStudent();

        System.out.println("@@@@@@@@@@@@@@@ Delete Student @@@@@@@@@@@@@@@");
        studentService.deleteStudent( 3);

        printStudent();

        System.out.println("@@@@@@@@@@@@@@@ Get one Student @@@@@@@@@@@@@@@");
        System.out.println(studentService.getOneStudent(1));

        System.out.println("@@@@@@@@@@@@@@@ Get Students by name @@@@@@@@@@@@@@@");
        studentService.getStudentsByName("Dan").forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@ Get Student avg grades @@@@@@@@@@@@@@@");
        System.out.println(studentService.avgStudentGrades(2));
    }

    public void printStudent(){
        studentService.getAllStudents().forEach(System.out::println);
    }
}
