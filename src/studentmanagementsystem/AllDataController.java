/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author rimon
 */
public class AllDataController implements Initializable {

    @FXML
    private AnchorPane AllDataTable;
    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Student, Integer> roll;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> email;
    @FXML
    private TableColumn<Student, Double> cgpa;
    @FXML
    private TableColumn<Student, String> password;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        roll.setCellValueFactory(new PropertyValueFactory<Student, Integer>("roll"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        cgpa.setCellValueFactory(new PropertyValueFactory<Student, Double>("cgpa"));
        email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<Student, String>("password"));
        try {
            MysqlConnection s= new MysqlConnection();
            s.ShowAll();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AllDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table.setItems(MysqlConnection.list);
    }   
}