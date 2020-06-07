package com.restApi.entity;

import java.io.Serializable;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  11:37
 */

//@Data
public class Class_ implements Serializable {
    private String code;
    private String title;
    private String description;

    public Class_(){
        this.code=getCode();
        this.title=getTitle();
        this.description=getDescription();
    }

    public Class_(String code, String title, String description) {
        this.setCode(code);
        this.setTitle(title);
        this.setDescription(description);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
