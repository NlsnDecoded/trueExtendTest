package com.restApi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  10:56
 */
@Data
public class Student implements Serializable {
    private String id;
    private String lastName;
    private String firstName;

    public Student() {
        this.id=getId();
        this.lastName=getLastName();
        this.firstName=getFirstName();
    }

    public Student(String id,String lastName,String firstName) {
        this.id=id;
        this.lastName=lastName;
        this.firstName=firstName;
    }
}
