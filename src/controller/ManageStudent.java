/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.DB;
import model.Student;

/**
 *
 * @author Cipla 1
 */
public class ManageStudent {
    Student student;
    
    public ManageStudent(){}
    
    public ManageStudent(Student student) {
        this.student = student;
    }

    public void saveStudent() {
        try {
            Connection con = DB.createConnection();
            String sql = "INSERT INTO student (RollNumber,Name,Gender,Contact,Address,Email,School,Grade,Password) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, student.RollNumber);
            stmt.setString(2, student.Name);
            stmt.setString(3, student.Gender);
            stmt.setString(4, student.Contact);
            stmt.setString(5, student.Address);
            stmt.setString(6, student.Email);
            stmt.setString(7, student.School);
            stmt.setInt(8, student.Grade);
            stmt.setString(9, student.Password);
            int result = stmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(getVisibleContent(), "Sucessfully registered!", "Student Management", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }
    
    public String getPassword(int ID) {
        String pw="";
        ResultSet result = null;
        try {
            Connection con = DB.createConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM student WHERE RollNumber = '" + ID + "'";
            result = stmt.executeQuery(sql);
            if(result.next()){
                pw = result.getString("Password");}
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
        return pw;
    }
    public String getName(int ID) {
        String name="";
        ResultSet result = null;
        try {
            Connection con = DB.createConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM student WHERE RollNumber = '" + ID + "'";
            result = stmt.executeQuery(sql);
            if(result.next()){
                name = result.getString("Name");}
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
        return name;
    }
    
    public ResultSet loadStudents(){
        ResultSet result = null;
        try{
            Connection con = DB.createConnection();
            Statement stmt = con.createStatement();
            String sql="SELECT * FROM student";
            result = stmt.executeQuery(sql);
        }catch(Exception e){}
        return result;
    }
    public ResultSet loadStudentByID(int ID) {
        ResultSet result = null;
        try {
            Connection con = DB.createConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM student WHERE RollNumber = '" + ID + "'";
            result = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return result;
    }

    Window getVisibleContent() {
        Window result = null;
        for (Window w : Window.getWindows()) {
            if (w.isVisible()) {
                result = w;
            }
        }
        return result;

    }

}
