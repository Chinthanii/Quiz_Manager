/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Cipla 1
 */
public class StudentResult {
    public int QuizId;
    public int StudentID;
    public int Result;
    public String Date;
    public int TimeMins;
    public int TimeSeconds;
    
    public StudentResult(int Studentid, int result, String date, int timemins,int timeSeconds){
    this.StudentID=Studentid;
    this.Result=result;
    this.TimeMins=timemins;
    this.TimeSeconds=timeSeconds;
    this.Date=date;
    }
    
    
    
}
