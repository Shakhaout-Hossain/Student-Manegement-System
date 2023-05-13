 
package studentmanagementsystem;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rimon
 */
public class AddOrDeleteController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Roll;
    @FXML
    private TextField Email;
    @FXML
    private TextField CGPA;
    @FXML
    private PasswordField Password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void CancelButton(ActionEvent event){
        
    }

    @FXML
    private void AddButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        int roll = Integer.parseInt(Roll.getText());
        String name = Name.getText();
        double cgpa = Double.parseDouble(CGPA.getText());
        String email = Email.getText();
        String password = Password.getText();
        Student std = new Student(name, roll, cgpa, email, password);
        MysqlConnection add = new MysqlConnection();
        add.AddStudent(std);
        Roll.clear();
        Name.clear();
        CGPA.clear();
        Email.clear();
        Password.clear();
    }    
}