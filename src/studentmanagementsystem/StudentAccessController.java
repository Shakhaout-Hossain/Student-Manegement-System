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
import javafx.scene.control.Label;
import static studentmanagementsystem.StudentManagementSystem.stage;

/**
 * FXML Controller class
 *
 * @author rimon
 */
public class StudentAccessController implements Initializable {
    @FXML
     Label Name;
    @FXML
    private Label Roll;
    @FXML
    private Label Email;
    @FXML
    private Label cgpa;
    @FXML
    private Label Rank;

    public StudentAccessController() {
        LogInOptionController.stage.close();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Name.setText(MysqlConnection.Std.getName());
        int r = MysqlConnection.Std.getRoll();
        String s = String.valueOf(r);
        Roll.setText(s);
        Email.setText(MysqlConnection.Std.getEmail());
        cgpa.setText(String.valueOf(MysqlConnection.Std.getCgpa()));
        Rank.setText(String.valueOf((MysqlConnection.rank)));
    }    

    @FXML
    private void BackToMain(ActionEvent event) throws IOException {
        StudentManagementSystem.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("LogInOption.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        FXMLDocumentController.stage.close();
        stage.show();
    }
}