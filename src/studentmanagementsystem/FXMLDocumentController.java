/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author rimon
 */
public class FXMLDocumentController implements Initializable {
    static int Roll;
    static String Pass;
    static Student Std ;
    private Label label;
    @FXML
    private TextField StudentId;
    @FXML
    private PasswordField StudentPassword;
    @FXML
    private Label wrong;
    
    static Stage stage = new Stage();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButton(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
        
        int id=Integer.parseInt(StudentId.getText());
        String pass=StudentPassword.getText();
        MysqlConnection s= new MysqlConnection();
        int p = s.ShowSTD(id,pass);
        if(p==0){
            wrong.setText("Please Enter Correct Id and Password");
        }
        else{
        Parent root = FXMLLoader.load(getClass().getResource("StudentAccess.fxml"));
        Scene scene = new Scene(root);    
        StudentManagementSystem.stage.close();
        stage.setScene(scene);
        stage.show();
         StudentAccessController ss = new StudentAccessController();   
        }
        StudentId.setText("");
        StudentPassword.setText("");
        
    }
    

    @FXML
    private void CancelButton(ActionEvent event) {
        StudentId.setText("");
        StudentPassword.setText("");
        wrong.setText("");
    }

    
}
