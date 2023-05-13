/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rimon
 */
public class TeacherLogInController implements Initializable {

    @FXML
    private TextField TeacherId;
    @FXML
    private PasswordField TeacherPassword;
    @FXML
    private Label wrong;
    static Stage stage = new Stage();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButton(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        String pass = TeacherPassword.getText();
        int id = Integer.parseInt(TeacherId.getText());
        int p=0;
        Class.forName("com.mysql.jdbc.Driver");
       Statement statement;
       try (Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/ruet","root","")) {
            statement = (Statement) connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from teacher where Id = "+id);            
            while(rs.next()){
            String s = rs.getString("password");
            if(s.equals(pass)){
            Parent root = FXMLLoader.load(getClass().getResource("TeacherAccess.fxml"));
            Scene scene = new Scene(root);
            StudentManagementSystem.stage.close();
            
            stage.setScene(scene);
            stage.show();
            p=1;
            LogInOptionController.stage.close();
            }
            }
            if(p==0){
                wrong.setText("Wrong Id or Password");
                TeacherId.setText("");
                TeacherPassword.setText("");
            }
        }
    }
    @FXML
    private void CancelButton(ActionEvent event) {
        TeacherId.setText("");
        TeacherPassword.setText("");
        wrong.setText("");
    }
    
}
