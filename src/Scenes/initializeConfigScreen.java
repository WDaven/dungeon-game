package Scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class initializeConfigScreen {
    // things to keep track of
    private static int gameDifficulty;
    private static String[] currWeaponList;
    private static String userInputName;

    public static Scene initConfigScreen() {

        // choose name
        Text textChooseName = new Text();
        textChooseName.setText("Type in your name:");

        TextField textInputName = new TextField();
        textInputName.setText("YOUR NAME HERE");

        Button buttonSetName = new Button();
        buttonSetName.setText("SET NAME");
        buttonSetName.setOnAction(e -> {
            userInputName = textInputName.getText();
            if (userInputName.equals("") || userInputName.equals(null) || userInputName.trim().length() == 0) {
                textInputName.setText("NAME CANNOT BE EMPTY, NULL, NOR JUST WHITE-SPACE!");
            }
        });


        // choose game difficulty
        Text textGameDifficulty = new Text();
        textGameDifficulty.setText("Choose your game difficulty:");

        Button buttonEasy = new Button();
        buttonEasy.setText("EASY");


        Button buttonNormal = new Button();
        buttonNormal.setText("NORMAL");

        Button buttonHard = new Button();
        buttonHard.setText("HARD");

        // button difficulty actions
        buttonEasy.setOnAction(e -> {
            gameDifficulty = 0;
            buttonEasy.setStyle("-fx-background-color: green;");  // Should we use a style sheet?
            buttonNormal.setStyle("-fx-background-color: white;");
            buttonHard.setStyle("-fx-background-color: white;");
        });
        buttonNormal.setOnAction(e -> {
            gameDifficulty = 1;
            buttonEasy.setStyle("-fx-background-color: white;");
            buttonNormal.setStyle("-fx-background-color: green;");  // Should we use a style sheet?
            buttonHard.setStyle("-fx-background-color: white;");
        });
        buttonHard.setOnAction(e -> {
            gameDifficulty = 2;
            buttonEasy.setStyle("-fx-background-color: white;");
            buttonNormal.setStyle("-fx-background-color: white;");
            buttonHard.setStyle("-fx-background-color: green;");  // Should we use a style sheet?
        });

        HBox hBoxGameDifficulty = new HBox();
        hBoxGameDifficulty.getChildren().addAll(buttonEasy, buttonNormal, buttonHard);

        // choose first weapon
        Text textFirstWeapon = new Text();
        textFirstWeapon.setText("Choose your first weapon:");

        Button buttonWeapon1 = new Button();
        buttonWeapon1.setText("WEAPON 1");  // replace with weapon picture later

        Button buttonWeapon2 = new Button();
        buttonWeapon2.setText("WEAPON 2");  // replace with weapon picture later

        Button buttonWeapon3 = new Button();
        buttonWeapon3.setText("WEAPON 3");  // replace with weapon picture later

        // button first weapon actions
        currWeaponList = new String[10];
        buttonWeapon1.setOnAction(e -> {
            currWeaponList[0] = textFirstWeapon.getText();
            buttonWeapon1.setStyle("-fx-background-color: green;");
            buttonWeapon2.setStyle("-fx-background-color: white;");
            buttonWeapon3.setStyle("-fx-background-color: white;");
        });
        buttonWeapon2.setOnAction(e -> {
            currWeaponList[0] = textFirstWeapon.getText();
            buttonWeapon1.setStyle("-fx-background-color: white;");
            buttonWeapon2.setStyle("-fx-background-color: green;");
            buttonWeapon3.setStyle("-fx-background-color: white;");
        });
        buttonWeapon3.setOnAction(e -> {
            currWeaponList[0] = textFirstWeapon.getText();
            buttonWeapon1.setStyle("-fx-background-color: white;");
            buttonWeapon2.setStyle("-fx-background-color: white;");
            buttonWeapon3.setStyle("-fx-background-color: green;");
        });

        HBox hBoxFirstWeapon = new HBox();
        hBoxFirstWeapon.getChildren().addAll(buttonWeapon1, buttonWeapon2, buttonWeapon3);

        // to go to next scene (initial game screen)
        Text textContinue = new Text();
        textContinue.setText("Proceed to next screen:");

        Button buttonContinue = new Button();
        buttonContinue.setText("CONTINUE");

        HBox hBoxContinue = new HBox();
        hBoxContinue.getChildren().addAll(buttonContinue);

        // main vBox for organization
        VBox vBoxMain = new VBox();
        vBoxMain.getChildren().addAll(textChooseName, textInputName, buttonSetName,
                textGameDifficulty, hBoxGameDifficulty, textFirstWeapon, hBoxFirstWeapon, textContinue, hBoxContinue);

        // to go to next scene ACTION
        //buttonNextScreen.setOnAction(e -> stage.setScene(initScene3()));    // call method of scene 3


        return new Scene(vBoxMain, 400, 600);
    }

}
