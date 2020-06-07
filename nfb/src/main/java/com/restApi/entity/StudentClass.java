package com.restApi.entity;

import lombok.Data;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  11:40
 */
@Data
public class StudentClass {
    private Student student;
    private Class_ class_;

    public StudentClass(Class_ class_,Student student) {
        this.setStudent(student);
        this.setClass_(class_);
    }

}
