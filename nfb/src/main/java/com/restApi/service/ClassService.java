package com.restApi.service;

import com.restApi.entity.Class_;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  11:44
 */

public class ClassService {
    private final static String[] title;

    private final static String[] description;

    static {
        title = new String[3];
        getTitle()[0] = "Math";
        getTitle()[1] = "Social";
        getTitle()[2] = "History";

        description = new String[3];
        getDescription()[0] = "Numbers and  more";
        getDescription()[1] = "Facebook and Instagram";
        getDescription()[2] = "About countrys";
    }

    public static String[] getTitle() {
        return title;
    }

    public static String[] getDescription() {
        return description;
    }

    public List<Class_> createClass() {
        List<Class_> list = new ArrayList<Class_>();
        for(int i = 0 ; i < 3 ; i++) {
            list.add(new Class_(getRandomId(), getTitle()[i], getDescription()[i]));
        }

        return list;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 3);
    }



}
