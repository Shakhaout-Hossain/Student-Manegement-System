/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author rimon
 */
public class DELETESTUDENTController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Roll;
    @FXML
    private TextField cgpa;
    @FXML
    private TextField Email;
    @FXML
    private PasswordField password;
    @FXML
    private Label Output;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DeleteButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        int roll = Integer.parseInt(Roll.getText());
        String name = Name.getText();
        double Cgpa = Double.parseDouble(cgpa.getText());
        String email = Email.getText();
        String Password = password.getText();
        Student std = new Student(name, roll, Cgpa, email, Password);
        MysqlConnection add = new MysqlConnection();
        int p = add.RemoveStudent(std);
        if(p==1){
            Output.setText("Delete Sucessful");
        }
        else{
            Output.setText("Please Enter Correct Data");
        }
        Name.clear();
        cgpa.clear();
        password.clear();
        Email.clear();
        Roll.clear();
    }

    @FXML
    private void CancelButton(ActionEvent event) {
        Name.clear();
        cgpa.clear();
        password.clear();
        Email.clear();
        Roll.clear();
        Output.setText("");
    }
    
}
