/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rimon
 */
public class MysqlConnection {
   
   static ObservableList<Student>list =FXCollections.observableArrayList();
   static Student Std;
   static int rank;
    public MysqlConnection() throws SQLException, ClassNotFoundException {
       /* Class.forName("com.mysql.jdbc.Driver");
        Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/ruet","root","");
        Statement statement = (Statement) connect.createStatement();
        ResultSet rs = statement.executeQuery("select * from student");
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        connect.close();
        statement.close();*/
    }
    void AddStudent(Student std) throws SQLException, ClassNotFoundException
    {
       Class.forName("com.mysql.jdbc.Driver");
       Statement statement;
       try (Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/ruet","root","")) {
           statement = (Statement) connect.createStatement();
           String query = "insert into student values("+std.getRoll()+",'"+std.getName()+"',"+std.getCgpa()+",'"+std.getPassword()+"','"+std.getEmail()+"')";
           statement.executeUpdate(query);
       }
       statement.close();
    }
    int RemoveStudent(Student std) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
       Statement statement;
       try (Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/ruet","root","")) {
           statement = (Statement) connect.createStatement();
           ResultSet rs = statement.executeQuery("select * from student");
           while(rs.next()){
               if(rs.getInt("Roll")==std.getRoll()){
                   String n = rs.getString("Name");
                   String p = rs.getString("Password");
                   String e = rs.getString("Email");
                   double c = rs.getDouble("CGPA");
                   String na = std.getName();
                   String em = std.getEmail();
                   String pa = std.getPassword();
                   double cg = std.getCgpa();
                   if(n.equals(na)&&e.equals(em)&&c==cg&&p.equals(pa)){
                       String query = "delete from student where Roll = "+std.getRoll();
                       statement.executeUpdate(query);
                       return 1;
                   }
               }
           }
       }
       statement.close();
        return 0;
       
    }
    
    void  ShowAll() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Statement statement;
        list.clear();
       try (Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/ruet","root","")) {
           statement = (Statement) connect.createStatement();
           ResultSet rs = statement.executeQuery("select * from student");
           while(rs.next()){
               String n = rs.getString("Name");
               String p = rs.getString("Password");
               String e = rs.getString("Email");
               double c = rs.getDouble("CGPA");
               int r = rs.getInt("Roll");
               Student std = new Student(n, r, c, e, p);
               list.add(std);
           }
           
       }
       statement.close();
        
    }
    
    int  ShowSTD(int roll, String str) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Statement statement;
       try (Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/ruet","root","")) {
           statement = (Statement) connect.createStatement();
           ResultSet rs = statement.executeQuery("select * from student order by student.cgpa desc");
           rank=0;
           while(rs.next()){
               rank++;
               String n = rs.getString("Name");
               String p = rs.getString("Password");
               String e = rs.getString("Email");
               double c = rs.getDouble("CGPA");
               int r = rs.getInt("Roll");
               if(roll==r&&p.equals(str)){
                   Student Std1 = new Student(n, r, c, e, p);
                   Std = Std1;
                   statement.close();
                   return 1;
               }
               
           }
       }
       statement.close();
       return 0;
        
    }
}