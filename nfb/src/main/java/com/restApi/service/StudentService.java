package com.restApi.service;

import com.restApi.entity.Class_;
import com.restApi.entity.Student;
import com.restApi.entity.StudentClass;

import java.util.UUID;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  13:15
 */

public class StudentService {

    public Student createStudent(Student student) {
        student.setId(getRandomId());
        student=new Student(student.getId(),student.getLastName(),student.getFirstName());
        return student;
    }

    public StudentClass createStudentClass(Class_ class_, Student student) {
        StudentClass studentClasses = new StudentClass(class_, student);
        return studentClasses;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 4);
    }
}
