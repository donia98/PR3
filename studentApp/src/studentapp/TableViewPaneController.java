/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nadoo
 */
public class TableViewPaneController implements Initializable {

    @FXML
    private TextField stdID;
    @FXML
    private TextField stdName;
    @FXML
    private TextField stdMajor;
    @FXML
    private TextField stdGrade;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> tcID;
    @FXML
    private TableColumn<?, ?> tcName;
    @FXML
    private TableColumn<?, ?> tcMajor;
    @FXML
    private TableColumn<?, ?> tcGrade;
    @FXML
    private Button buttonAddStd;
    @FXML
    private Button buttonUpdateStd;
    @FXML
    private Button buttonDeleteStd;
    @FXML
    private Button buttonAddCourse;
    @FXML
    private Button buttonReset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonAddHandle(ActionEvent event) {
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) {
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
    }
    
}
