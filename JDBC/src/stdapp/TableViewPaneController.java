/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdapp;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Course, Double> tcGrade;
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
    
    Statement statement;
    @FXML
    private Button buttonShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection
                    = DriverManager.
                            getConnection("jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC",
                                    "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("stdId"));
        tcName.setCellValueFactory(new PropertyValueFactory("stdName"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("stdMajor"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("stdGrade"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedStudent());

    } 
    
        @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception{
        ResultSet rs = this.statement.executeQuery("Select * From Student");
        tableView.getItems().clear();
        while(rs.next()){
            Student std = new Student();
            std.setStdId(rs.getInt("stdID"));
            std.setStdName(rs.getString("stdName"));
            std.setStdMajor(rs.getString("stdMajor"));
            std.setStdGrade(rs.getDouble("stdGrade"));
            tableView.getItems().add(std);
        }
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
    private void showSelectedStudent(){
        Student std = tableView.getSelectionModel().getSelectedItem();
        if(std != null){
        stdID.setText(String.valueOf(std.getStdId()));
        stdName.setText(std.getStdName());
        stdMajor.setText(std.getStdMajor());
        stdGrade.setText(String.valueOf(std.getStdGrade()));
        }

    }

}
