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
import java.sql.SQLException;
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
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedStudent());

    }

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception {
        ResultSet rs = this.statement.executeQuery("Select * From Student");
        tableView.getItems().clear();
        while (rs.next()) {
            Student std = new Student();
            std.setStdId(rs.getInt("id"));
            std.setStdName(rs.getString("name"));
            std.setStdMajor(rs.getString("major"));
            std.setStdGrade(rs.getDouble("grade"));
            tableView.getItems().add(std);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws SQLException {
        Integer id = Integer.parseInt(stdID.getText());
        String name = stdName.getText();
        String major = stdMajor.getText();
        Double grade = Double.parseDouble(stdGrade.getText());
        String sql = "Insert Into Student values(" + id + ",'" + name + "','"
                + major + "'," + grade + ")";
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws SQLException {
                Integer id = Integer.parseInt(stdID.getText());
        String name = stdName.getText();
        String major = stdMajor.getText();
        Double grade = Double.parseDouble(stdGrade.getText());
        String sql = "Update Student Set name='" + name + "', major='" + 
                major + "', grade=" + grade + " Where id=" +id;
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }

    private void resetControls() {
        stdID.setText("");
        stdName.setText("");
        stdMajor.setText("");
        stdGrade.setText("");
        tableView.getItems().clear();
    }

    private void showSelectedStudent() {
        Student std = tableView.getSelectionModel().getSelectedItem();
        if (std != null) {
            stdID.setText(String.valueOf(std.getStdId()));
            stdName.setText(std.getStdName());
            stdMajor.setText(std.getStdMajor());
            stdGrade.setText(String.valueOf(std.getStdGrade()));
        }

    }

}
