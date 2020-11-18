package Controler;

import Model.StudentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
    private static final String connURL = "jdbc:mysql://localhost:3306/school";
    private static final String connUser = "root";
    private static final String connPass = "";
    List<StudentModel> studentModelList = new ArrayList<>();

    public List<StudentModel> LoadStudent() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            ResultSet rSet = stmt.executeQuery("SELECT * FROM student");
            while (rSet.next()) {
                String StudentID = rSet.getString("studentID");
                String StudentName = rSet.getString("StudentName");
                String Address = rSet.getString("Address");
                String Phone = rSet.getString("Phone");

                StudentModel student = new StudentModel(StudentID, StudentName, Address, Phone);
                studentModelList.add(student);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return studentModelList;
    }

    public void DisplayRecord() {
        Iterator<StudentModel> studentModelIterator = studentModelList.iterator();
        while (studentModelIterator.hasNext()) {
            StudentModel s1 = studentModelIterator.next();
            System.out.println(s1);
        }
    }

    public void AddStudent() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter student ID:");
        String StudentID = input.nextLine();

        System.out.println("Enter student name: ");
        String StudentName = input.nextLine();

        System.out.println("Enter student address: ");
        String Address = input.nextLine();

        System.out.println("Enter student phone number: ");
        String Phone = input.next();

        StudentModel student = new StudentModel(StudentID, StudentName, Address, Phone);
        studentModelList.add(new StudentModel(student.getStudentID(), student.getStudentName(), student.getAddress(), student.getPhone()));
    }

    public void InsertStudent(StudentModel studentModel) {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlInsert = "Insert into student values (' "
                    + studentModel.getStudentID() + "','"
                    + studentModel.getStudentName() + "','"
                    + studentModel.getAddress() + "','"
                    + studentModel.getPhone() + "')";
            stmt.executeUpdate(sqlInsert);
            System.out.println("Record Saved!");
            studentModelList.clear();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void SaveStudent(){
        Iterator<StudentModel> studentModelIterator = studentModelList.iterator();
        while (studentModelIterator.hasNext()){
            StudentModel newStudent = studentModelIterator.next();
            InsertStudent(newStudent);
        }
    }
}
