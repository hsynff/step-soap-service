package com.step.ws.soap;

import com.step.ws.dao.StudentDao;
import com.step.ws.exceptions.UserNotFoundException;
import com.step.ws.model.Student;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public class StudentService {

    private StudentDao studentDao = new StudentDao();

    @WebMethod
    @WebResult(name = "student")
    public List<Student> getAllStudent(){
        return studentDao.getAllStudent();
    }

    @WebMethod
    @WebResult(name = "student")
    public Student getStudentById(@WebParam(name = "id") int id) throws UserNotFoundException {
        return studentDao.getStudentById(id);
    }

    @WebMethod
    public void addStudent(@WebParam(name = "student") Student student){
        studentDao.addStudent(student);
    }

    @WebMethod
    public void deleteStudent(@WebParam(name = "id") int id) throws UserNotFoundException {
        studentDao.deleteStudent(id);
    }

    @WebMethod
    public void updateStudent(@WebParam(name = "student") Student student) throws UserNotFoundException {
        studentDao.updateStudent(student);
    }
}
