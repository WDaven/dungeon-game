package sample;

import Scenes.initializeConfigScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Welcome!!!");
        Button btn = new Button();
        btn.setText("START GAME");
        Scene scene = new Scene(new BorderPane());
        //when start game button is clicked, call method that returns a different screen
        btn.setOnAction((event) -> {
            primaryStage.setScene(initializeConfigScreen.initConfigScreen());
        });

        Text txt = new Text("Welcome to Bent Ostriches' Dungeon Crawler Game!");
        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(txt);
        borderpane.setBottom(btn);
        borderpane.setAlignment(btn, Pos.CENTER);
        primaryStage.setScene(new Scene(borderpane, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
