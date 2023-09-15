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
public class Student {

    public int RollNumber;
    public String Name;
    public String Gender;
    public String Contact;
    public String Address;
    public String Email;
    public String School;
    public int Grade;
    public String Password;

    public Student(int rollNumber, String name, String gender, String contact, String address, String email, String school, int grade, String password) {
        this.RollNumber = rollNumber;
        this.Name = name;
        this.Contact = contact;
        this.Email = email;
        this.Address = address;
        this.Gender = gender;
        this.School = school;
        this.Grade = grade;
        this.Password = password;
    }

}
