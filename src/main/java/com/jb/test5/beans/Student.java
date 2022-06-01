package com.jb.test5.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date birthday;
    private boolean isActive;
    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL})
    @Singular
    @ToString.Exclude
    @JsonManagedReference
    private List<Grade> grades = new ArrayList<>();
}
