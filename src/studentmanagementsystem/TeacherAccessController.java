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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import static studentmanagementsystem.StudentManagementSystem.stage;

/**
 * FXML Controller class
 *
 * @author rimon
 */
public class TeacherAccessController implements Initializable {

    @FXML
    private VBox BOX;
    @FXML
    private AnchorPane Main;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Parent root = FXMLLoader.load(getClass().getResource("DefaultImage.fxml"));
            BOX.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(TeacherAccessController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void AddStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddOrDelete.fxml"));
        BOX.getChildren().clear();
        BOX.getChildren().add(root);
    }

    @FXML
    private void RemoveStudent(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("DELETESTUDENT.fxml"));
        BOX.getChildren().clear();
        BOX.getChildren().add(root);
    }


    @FXML
    private void ShowAll(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("AllData.fxml"));
        BOX.getChildren().clear();
        BOX.getChildren().add(root);
        AllDataController a = new AllDataController();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        StudentManagementSystem.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("LogInOption.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        TeacherLogInController.stage.close();
        stage.show();
    }
    
}
