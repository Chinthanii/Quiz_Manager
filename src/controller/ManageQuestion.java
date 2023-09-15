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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DB;
import model.Question;

/**
 *
 * @author Cipla 1
 */
public class ManageQuestion {
    Question question;
    
    public ManageQuestion(){}
    public ManageQuestion(Question question)
    {this.question = question;}
    
    public void saveQuestion() {
        try {
            Connection con = DB.createConnection();
            String sql = "INSERT INTO question (QuestionID,Question,OptionA,OptionB,OptionC,OptionD,Answer) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, question.QuestionID);
            stmt.setString(2, question.Question);
            stmt.setString(3, question.OptionA);
            stmt.setString(4, question.OptionB);
            stmt.setString(5, question.OptionC);
            stmt.setString(6, question.OptionD);
            stmt.setString(7, question.Answer);
            
            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("Successfully Saved");
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }
    public void updateQuestion(int id)
    {try {
            Connection con = DB.createConnection();
            String sql = "UPDATE question SET Question=?,OptionA=?,OptionB=?,OptionC=?,OptionD=?,Answer=? WHERE QuestionID='"+id+"'";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, question.Question);
            stmt.setString(2, question.OptionA);
            stmt.setString(3, question.OptionB);
            stmt.setString(4, question.OptionC);
            stmt.setString(5, question.OptionD);
            stmt.setString(6, question.Answer);
            
            int result = stmt.executeUpdate();

            if (result > 0) {
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,"Successfully Updated");
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    
    }
    public ResultSet loadQuestions(){
        ResultSet result = null;
        try{
            Connection con = DB.createConnection();
            Statement stmt = con.createStatement();
            String sql="SELECT * FROM question";
            result = stmt.executeQuery(sql);
        }catch(Exception e){}
        return result;
    }
    public ResultSet loadQuestionByID(int ID) {
        ResultSet result = null;
        try {
            Connection con = DB.createConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM question WHERE QuestionID = '" + ID + "'";
            result = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return result;
    }
    public String getQuestion(int ID,String Field) {
        String Question ="";
        ResultSet result = null;
        try {
            Connection con = DB.createConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM question WHERE QuestionID = '" + ID + "'";
            result = stmt.executeQuery(sql);
            if(result.next()){
                Question = result.getString(Field);}
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
        return Question;
    }
    
}
