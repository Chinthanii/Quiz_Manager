/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.DB;
import model.Student;
import model.StudentResult;

/**
 *
 * @author Cipla 1
 */
public class ManageStudentResult {
    StudentResult studentResult;
    
    public ManageStudentResult(){}
    
    public ManageStudentResult(StudentResult studentResult) {
        this.studentResult = studentResult;
    }

    public void saveStudentResult() {
        try {
            Connection con = DB.createConnection();
            String sql = "INSERT INTO results (StudentID,Result,Date,TimeMins,TimeSeconds) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, studentResult.StudentID);
            stmt.setInt(2, studentResult.Result);
            stmt.setString(3, studentResult.Date);
            stmt.setInt(4, studentResult.TimeMins);
            stmt.setInt(5, studentResult.TimeSeconds);
            
            
            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("Submited Successfully");
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }
    public ResultSet loadResultDetails(){
        ResultSet result = null;
        try{
            Connection con = DB.createConnection();
            Statement stmt = con.createStatement();
            String sql="SELECT * FROM results";
            result = stmt.executeQuery(sql);
        }catch(Exception e){}
        return result;
    }
}
