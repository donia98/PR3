/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nadoo
 */
public class StudentApp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader= new 
           FXMLLoader(getClass().getResource("TableViewPane.fxml"));
        loader.setController(this);
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First JavaFX App");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
