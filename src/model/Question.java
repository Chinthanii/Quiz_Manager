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
public class Question {
    public int QuestionID;
    public String Question;
    public String OptionA;
    public String OptionB;
    public String OptionC;
    public String OptionD;
    public String Answer;
    
    public Question(int questionID,String question,String optionA,String optionB,String optionC,String optionD,String answere)
    {
        this.QuestionID=questionID;
        this.Question=question;
        this.OptionA=optionA;
        this.OptionB=optionB;
        this.OptionC=optionC;
        this.OptionD=optionD;
        this.Answer=answere;
    
    
    }
    public Question(){}
    
}
