package org.example.demofx2.repository;

import org.example.demofx2.entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentRepository {

    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/student_manager";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    public void save(Student student){
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String strSql = "insert into students (code, fullName, phone, email) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1, student.getCode());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> findAll(){
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prSql = "select * from students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prSql);
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                Student obj = new Student();
                obj.setCode(code);
                obj.setFullName(fullName);
                obj.setPhone(phone);
                students.add(obj);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student();
        student.setCode("ST001");
        student.setFullName("Hong Luyen");
        student.setEmail("luyen@gmail.com");
        student.setPhone("01923123321");
        studentRepository.save(student);
        System.out.println("Success");
    }
}
