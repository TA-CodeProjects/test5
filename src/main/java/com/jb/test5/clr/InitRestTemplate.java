package com.jb.test5.clr;

import com.jb.test5.beans.Grade;
import com.jb.test5.beans.Student;
import com.jb.test5.beans.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@Service
@Order(2)
@RequiredArgsConstructor
public class InitRestTemplate implements CommandLineRunner {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8080/api/students/";


    @Override
    public void run(String... args) throws Exception {
        Grade grade1 = new Grade(Topic.PROJECTS1, 90);
        Grade grade2 = new Grade(Topic.PROJECTS2, 80);
        Grade grade3 = new Grade(Topic.PROJECTS3, 100);

        Student toAdd = Student.builder().name("David")
                .birthday(Date.valueOf(LocalDate.of(2000, 4,21)))
                .isActive(true)
                .grade(grade1)
                .grade(grade2)
                .grade(grade3)
                .build();

        grade1.setStudent(toAdd);
        grade2.setStudent(toAdd);
        grade3.setStudent(toAdd);

        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@ Add Student @@@@@@@@@@@@@@@");
        try {
            ResponseEntity<String> res1 = restTemplate.postForEntity(url, toAdd, String.class);
            System.out.println(res1.getStatusCodeValue() == HttpStatus.CREATED.value() ? "Added" : "Not Added");

            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@ Delete Student @@@@@@@@@@@@@@@");

            restTemplate.delete(url + "1");
            System.out.println("deleted student  1");

            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@ Get One Student @@@@@@@@@@@@@@@");

            Student student1 = restTemplate.getForObject(url + "2", Student.class);
            System.out.println(student1);

            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@ Get All Students @@@@@@@@@@@@@@@");
            Student[] students = restTemplate.getForObject(url, Student[].class);
            List<Student> students1 = Arrays.stream(students).collect(Collectors.toList());
            students1.forEach(System.out::println);

            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@ Get Students by name @@@@@@@@@@@@@@@");
            Student[] students2 = restTemplate.getForObject(url + "ByName?name=David", Student[].class);
            List<Student> students3 = Arrays.stream(students2).collect(Collectors.toList());
            students3.forEach(System.out::println);

            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@ Get Student avg grades @@@@@@@@@@@@@@@");
            double avgGrades = restTemplate.getForObject(url + "AvgGrade/2", double.class);
            System.out.println(avgGrades);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
