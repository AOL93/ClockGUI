package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Alarm Clock - GUI");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

//TODO Style Spinners (center text in Spinner somehow :O).
//TODO Time in Spinners always 2 digits.
//TODO Add forgotten components. (Alarm name and repeat).