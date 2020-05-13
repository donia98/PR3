package stdapp;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Donia Hassona
 * @id 20160783
 */
public class StdApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane paneTableView = FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("tableView", paneTableView);
        Scene scene = new Scene(mapPanes.get("tableView"));
        primaryStage.setTitle("Student App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
