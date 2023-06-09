/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rimon
 */
public class LogInOptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static Stage stage = new Stage();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void StudentLogIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene); 
        stage.show();
        StudentManagementSystem.stage.close();
    }

    @FXML
    private void TeacherLogIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TeacherLogIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene); 
        stage.show();
        StudentManagementSystem.stage.close();
    }
    
}
