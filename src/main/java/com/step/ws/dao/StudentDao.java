package com.step.ws.dao;


import com.step.ws.constants.MessageConstants;
import com.step.ws.exceptions.UserNotFoundException;
import com.step.ws.model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentDao {
    private static final List<Student> list = new ArrayList<>();
    private static int idSequence = 5;

    static {
        list.add(new Student(1, "John"));
        list.add(new Student(2, "Merry"));
        list.add(new Student(3, "Kennedy"));
        list.add(new Student(4, "David"));
        list.add(new Student(5, "Memmed"));
    }


    public List<Student> getAllStudent(){
        return list;
    }

    public Student getStudentById(int id) throws UserNotFoundException {
        Student student = list.stream()
                .filter(s -> s.getId()==id)
                .findFirst()
                .orElse(null);

        if (student==null){
            throw new UserNotFoundException(MessageConstants.ERROR_USER_NOT_FOUND,
                    MessageConstants.errorCodeOf(MessageConstants.ERROR_USER_NOT_FOUND));
        }

        return student;
    }

    public Student addStudent(Student student){
        student.setId(++idSequence);
        list.add(student);
        return student;
    }

    public Student deleteStudent(int id) throws UserNotFoundException {
        Student student = getStudentById(id);

        list.removeIf(s -> s.getId()==id);

        return student;
    }

    public Student updateStudent(Student student) throws UserNotFoundException {
        Student oldStudent = getStudentById(student.getId());

        oldStudent.setName(student.getName());

        return oldStudent;
    }
}
