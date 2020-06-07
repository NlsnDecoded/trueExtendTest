package com.restApi.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.JsonObject;
import com.restApi.ErrorException;
import com.restApi.entity.Class_;
import com.restApi.entity.Student;
import com.restApi.entity.StudentClass;
import com.restApi.service.ClassService;
import com.restApi.service.StudentService;
import org.primefaces.json.JSONObject;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.restApi.Util.Util.readJsonValue;
import static com.restApi.Util.Util.sendRestEntityPOSTJSON;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  11:54
 */
@ManagedBean("mainController")
@ViewScoped
public class MainController implements Serializable {

    private Student student = new Student();
    private Class_ selectedClass = new Class_();

    private List<Class_> classList = new ArrayList<Class_>();
    private List<Student> studentList = new ArrayList<Student>();
    private List<StudentClass> studentClassList = new ArrayList<StudentClass>();

    private ClassService classService = new ClassService();


    @PostConstruct
    public void init() {
        classList = classService.createClass();
    }


    public String addStudent() throws ErrorException {

        JSONObject object = new JSONObject(student);
        JSONObject objectResult = sendRestEntityPOSTJSON("/createStudent", object.toString());

        student=readJsonValue(objectResult,"studentNew", Student.class);

        objectResult = sendRestEntityPOSTJSON("/listOfStudents", object.toString());
        studentList = readJsonValue(objectResult, "studentList", new TypeReference<List<Student>>() {
        });

        object = new JSONObject();
        JSONObject ob1 = new JSONObject(student);
        JSONObject ob2 = new JSONObject(selectedClass);

        object.put("student",ob1);
        object.put("class",ob2);

        sendRestEntityPOSTJSON("/createStudentClass", object.toString());

        JSONObject objectListClassResult =  sendRestEntityPOSTJSON("/studentClassList", object.toString());
//        studentClassList= readJsonValue(objectListClassResult,"list", new TypeReference<List<StudentClass>>() {
//        });

        return null;
    }


    public void setService(ClassService classService) {
        this.classService = classService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Class_> getClassList() {
        return classList;
    }

    public void setClassList(List<Class_> classList) {
        this.classList = classList;
    }


    public Class_ getSelectedClass() {
        return selectedClass;
    }

    public void setSelectedClass(Class_ selectedClass) {
        this.selectedClass = selectedClass;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<StudentClass> getStudentClassList() {
        return studentClassList;
    }

    public void setStudentClassList(List<StudentClass> studentClassList) {
        this.studentClassList = studentClassList;
    }
}
