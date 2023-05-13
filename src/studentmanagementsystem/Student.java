/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

/**
 *
 * @author rimon
 */
public class Student {
    private String name ;
    private int roll;
    private double cgpa;
    private String email, password;

    Student() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPassword() {
        return password;
    }

    public Student(String name, int roll, double cgpa, String email, String password) {
        this.name = name;
        this.roll = roll;
        this.cgpa = cgpa;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
