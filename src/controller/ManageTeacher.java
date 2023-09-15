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
import model.Teacher;

/**
 *
 * @author Cipla 1
 */
public class ManageTeacher {
    Teacher teacher ;
    
    public ManageTeacher(){}
    
    public ManageTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public void saveTeacher() {
        try {
            Connection con = DB.createConnection();
            String sql = "INSERT INTO Teacher (TeacherID,Name,Contact,Email,Address,Gender,Password) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, teacher.RollNumber);
            stmt.setString(2, teacher.Name);
            stmt.setString(3, teacher.Contact);
            stmt.setString(4, teacher.Email);
            stmt.setString(5, teacher.Address);
            stmt.setString(6, teacher.Gender);
            stmt.setString(7, teacher.Password);
            int result = stmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(getVisibleContent(), "Sucessfully registered!", "Quiz Management", JOptionPane.INFORMATION_MESSAGE);

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
            String sql = "SELECT * FROM teacher WHERE TeacherID = '" + ID + "'";
            result = stmt.executeQuery(sql);
            if(result.next()){
                pw = result.getString("Password");}
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
        return pw;
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
