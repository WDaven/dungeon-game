package scenes;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class InitializeConfigScreen {
    // things to keep track of
    private static int gameDifficulty;
    private static String[] currWeaponList;
    private static String userInputName;
    private static Button buttonContinue;
    private static Text textChooseName;
    private static TextField textInputName;
    private static Button buttonSetName;
    private static Text textGameDifficulty;
    private static Button buttonEasy;
    private static Button buttonNormal;
    private static Button buttonHard;
    private static Button buttonWeapon1;
    private static Button buttonWeapon2;
    private static Button buttonWeapon3;
    private static Text textFirstWeapon;
    private static Text textContinue;
    private static String weapon1 = "dagger";
    private static String weapon2 = "sword";
    private static String weapon3 = "greatsword";

    public static String getWeapon1() {
        return weapon1;
    }

    public static void setWeapon1(String weapon1) {
        InitializeConfigScreen.weapon1 = weapon1;
    }

    public static String getWeapon2() {
        return weapon2;
    }

    public static void setWeapon2(String weapon2) {
        InitializeConfigScreen.weapon2 = weapon2;
    }

    public static String getWeapon3() {
        return weapon3;
    }

    public static void setWeapon3(String weapon3) {
        InitializeConfigScreen.weapon3 = weapon3;
    }

    public static String getUserInputName() {
        return userInputName;
    }

    public static void setUserInputName(String userInputName) {
        InitializeConfigScreen.userInputName = userInputName;
    }

    public static int getGameDifficulty() {
        return gameDifficulty;
    }

    public static void setGameDifficulty(int gameDifficulty) {
        InitializeConfigScreen.gameDifficulty = gameDifficulty;
    }

    public static String[] getCurrWeaponList() {
        return currWeaponList;
    }

    public static void setTextInputName(TextField textInputName) {
        scenes.InitializeConfigScreen.textInputName = textInputName;
    }

    public static Scene initConfigScreen(Stage primaryStage) {

        // choose name
        textChooseName = new Text();
        textChooseName.setText("Type in your name:");

        textInputName = new TextField();
        textInputName.setText("YOUR NAME HERE");

        buttonSetName = new Button();
        buttonSetName.setText("SET NAME");
        buttonSetName.setOnAction(e -> {
            userInputName = textInputName.getText();
            if (userInputName.equals("") || userInputName.equals(null)
                    || userInputName.trim().length() == 0) {
                Alert alertNull = new Alert(Alert.AlertType.WARNING,
                        ("NAME CANNOT BE EMPTY, NULL, NOR JUST WHITE-SPACE!"));
                alertNull.show();
            }
        });


        // choose game difficulty
        textGameDifficulty = new Text();
        textGameDifficulty.setText("Choose your game difficulty:");

        buttonEasy = new Button();
        buttonEasy.setText("EASY");


        buttonNormal = new Button();
        buttonNormal.setText("NORMAL");

        buttonHard = new Button();
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
        textFirstWeapon = new Text();
        textFirstWeapon.setText("Choose your first weapon:");

        buttonWeapon1 = new Button();
        buttonWeapon1.setText(weapon1);  // replace with weapon picture later

        buttonWeapon2 = new Button();
        buttonWeapon2.setText(weapon2);  // replace with weapon picture later

        buttonWeapon3 = new Button();
        buttonWeapon3.setText(weapon3);  // replace with weapon picture later

        // button first weapon actions
        currWeaponList = new String[10];
        buttonWeapon1.setOnAction(e -> {
            currWeaponList[0] = weapon1;
            buttonWeapon1.setStyle("-fx-background-color: green;");
            buttonWeapon2.setStyle("-fx-background-color: white;");
            buttonWeapon3.setStyle("-fx-background-color: white;");
        });
        buttonWeapon2.setOnAction(e -> {
            currWeaponList[0] = weapon2;
            buttonWeapon1.setStyle("-fx-background-color: white;");
            buttonWeapon2.setStyle("-fx-background-color: green;");
            buttonWeapon3.setStyle("-fx-background-color: white;");
        });
        buttonWeapon3.setOnAction(e -> {
            currWeaponList[0] = weapon3;
            buttonWeapon1.setStyle("-fx-background-color: white;");
            buttonWeapon2.setStyle("-fx-background-color: white;");
            buttonWeapon3.setStyle("-fx-background-color: green;");
        });

        HBox hBoxFirstWeapon = new HBox();
        hBoxFirstWeapon.getChildren().addAll(buttonWeapon1, buttonWeapon2, buttonWeapon3);

        // to go to next scene (initial game screen)
        textContinue = new Text();
        textContinue.setText("Proceed to next screen:");

        buttonContinue = new Button();
        buttonContinue.setText("CONTINUE");
        buttonContinue.setOnAction(e -> {
            primaryStage.setScene(InitialGameScreen.start(primaryStage));
        });

        HBox hBoxContinue = new HBox();
        hBoxContinue.getChildren().addAll(buttonContinue);

        // main vBox for organization
        VBox vBoxMain = new VBox();
        vBoxMain.getChildren().addAll(textChooseName, textInputName, buttonSetName,
                textGameDifficulty, hBoxGameDifficulty, textFirstWeapon,
                hBoxFirstWeapon, textContinue, hBoxContinue);

        // to go to next scene ACTION
        //buttonNextScreen.setOnAction(e -> stage.setScene(initScene3()));
        // call method of scene 3

        return new Scene(vBoxMain, 400, 600);
    }

}
