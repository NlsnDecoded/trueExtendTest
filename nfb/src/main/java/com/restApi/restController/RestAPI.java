package com.restApi.restController;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 06-jun.-2020  16:09
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.restApi.entity.Class_;
import com.restApi.entity.Student;
import com.restApi.entity.StudentClass;
import com.restApi.service.StudentService;
import org.primefaces.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

import static com.restApi.Util.Util.readJsonValue;
import static com.restApi.Util.Util.restOK;

@Controller
@RequestMapping(value = "/restService")
public class RestAPI {

    private StudentService studentService = new StudentService();
    private List<Student> studentList = new ArrayList<Student>();
    private List<StudentClass> studentClassList = new ArrayList<StudentClass>();

    @RequestMapping(value = "/createStudent", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Response createStudent(@RequestBody String datosJson) throws Exception {

        JSONObject object = new JSONObject(datosJson);
        Student student = readJsonValue(object, Student.class);

        Student studentNew = new Student();
        studentNew = studentService.createStudent(student);
        studentList.add(studentNew);

        Map map = new HashMap<>();
        map.put("studentNew", studentNew);

        return Response.ok(restOK(map)).build();
    }


    @RequestMapping(value = "/listOfStudents", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Response listStudents() throws Exception {
        Map map = new HashMap<>();
        map.put("studentList", studentList);
        return Response.ok(restOK(map)).build();
    }


    @RequestMapping(value = "/createStudentClass", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Response createStudentClass(@RequestBody String datosJson) throws Exception {

        JSONObject object = new JSONObject(datosJson);

        Student student = readJsonValue((JSONObject) object.get("student"), Student.class);
        Class_ class_ = readJsonValue((JSONObject) object.get("class"), Class_.class);

        StudentClass newStudentClass = studentService.createStudentClass(class_, student);
        studentClassList.add(newStudentClass);


        Map map = new HashMap<>();

        return Response.ok(restOK(map)).build();
    }


    @RequestMapping(value = "/studentClassList", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Response listClassStudents() throws Exception {
        Map map = new HashMap<>();
        map.put("list", studentClassList);
        return Response.ok(restOK(map)).build();
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



