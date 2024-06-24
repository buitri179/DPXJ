package org.example.demofx2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.demofx2.entity.Student;
import org.example.demofx2.repository.StudentRepository;

public class StudentForm {

    public TextField studentName;
    public TextField studentPhone;
    public TextField studentEmail;
    public TextField studentCode;
    private StudentRepository studentRepository = new StudentRepository();

    public void doSomething(ActionEvent actionEvent) {
        // validate
        Student student = new Student();
        student.setCode(studentCode.getText());
        student.setEmail(studentEmail.getText());
        student.setPhone(studentPhone.getText());
        student.setFullName(studentName.getText());
        studentRepository.save(student);
        System.out.println("Success");
    }
}
