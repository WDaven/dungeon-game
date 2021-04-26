package scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {
    private Text txt;
    private Button startButton;

    public void setTxt(Text txt) {
        this.txt = txt;
    }

    public void setStartButton(Button startButton) {
        this.startButton = startButton;
    }

    public Text getTxt() {
        return txt;
    }

    public Button getStartButton() {
        return startButton;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Welcome!!!");
        startButton = new Button();
        startButton.setText("START GAME");
        Scene scene = new Scene(new BorderPane());
        //when start game button is clicked, call method that returns a different screen
        startButton.setOnAction((event) -> {
            primaryStage.setScene(InitializeConfigScreen.initConfigScreen(primaryStage));
        });

        txt = new Text("Welcome to Bent Ostriches' Dungeon Crawler Game!");
        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(txt);
        borderpane.setBottom(startButton);
        borderpane.setAlignment(startButton, Pos.CENTER);
        primaryStage.setScene(new Scene(borderpane, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}