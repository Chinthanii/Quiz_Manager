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
public class Teacher {
    public int RollNumber;
    public String Name;
    public String Contact;
    public String Email;
    public String Address;
    public String Gender;
    public String Password;

    public Teacher(int rollNumber, String name,  String contact, String email,String address, String gender, String password) 
    {
        this.RollNumber = rollNumber;
        this.Name = name;
        this.Contact = contact;
        this.Email = email;
        this.Address = address;
        this.Gender = gender;
        this.Password = password;}
}
