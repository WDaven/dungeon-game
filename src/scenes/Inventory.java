package scenes;

import javafx.geometry.Pos;
import generators.Maze;
import generators.Maze.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static generators.Maze.getPlayer;

public class Inventory {
    private static BorderPane background;
    private static Button back;
    private static Label weapons;
    private static int numDaggers;
    private static Label daggers;
    private static Label swords;
    private static Label greatSwords;
    private static int numSwords;
    private static int numGSwords;
    private static Label potions;
    private static Label hPotion;
    private static Label aPotion;
    private static int numHPotion;
    private static int numAPotion;
    private static Label crystals;
    private static int numCrystals;

    // setters

    public static void setNumDaggers(int numDaggers) {
        Inventory.numDaggers = numDaggers;
    }

    public static void setNumSwords(int numSwords) {
        Inventory.numSwords = numSwords;
    }

    public static void setNumGSwords(int numGSwords) {
        Inventory.numGSwords = numGSwords;
    }

    public static void setNumHPotion(int numHPotion) {
        Inventory.numHPotion = numHPotion;
    }

    public static void setNumAPotion(int numAPotion) {
        Inventory.numAPotion = numAPotion;
    }

    public static void setNumCrystals(int numCrystals) {
        Inventory.numCrystals = numCrystals;
    }

    // getters

    public static int getNumDaggers() {
        return numDaggers;
    }

    public static int getNumSwords() {
        return numSwords;
    }

    public static int getNumGSwords() {
        return numGSwords;
    }

    public static int getNumHPotion() {
        return numHPotion;
    }

    public static int getNumAPotion() {
        return numAPotion;
    }

    public static int getNumCrystals() {
        return numCrystals;
    }

    public static Scene start(Stage primaryStage, Maze maze, Node curr) {
        // adding original weapon
//        if (Maze.getPlayer().getPlayerDamage() == 8) {
//            numDaggers++;
//        } else if (Maze.getPlayer().getPlayerDamage() == 10) {
//            numSwords++;
//        } else {
//            numGSwords++;
//        }

        // weapons vbox
        VBox weaponsBox = new VBox(10);
        weapons = new Label("Weapons:");
        daggers = new Label("Daggers: ");
        swords = new Label("Swords: ");
        greatSwords = new Label("Great Swords ");
        daggers.setText(daggers.getText().concat(String.valueOf(getNumDaggers())));
        swords.setText(swords.getText().concat(String.valueOf(getNumSwords())));
        greatSwords.setText(greatSwords.getText().concat(String.valueOf(getNumGSwords())));
        weaponsBox.getChildren().addAll(weapons, daggers, swords, greatSwords);

        // potions box
        VBox potionsBox = new VBox(10);
        potions = new Label("Potions: ");
        hPotion = new Label("Health Potions: ");
        aPotion = new Label("Attack Potions: ");
        hPotion.setText(hPotion.getText().concat(String.valueOf(getNumHPotion())));
        aPotion.setText(aPotion.getText().concat(String.valueOf(getNumAPotion())));
        potionsBox.getChildren().addAll(potions, hPotion, aPotion);

        // crystals box
        VBox crystalsBox = new VBox(10);
        crystals= new Label("Magic Crystals: ");
        crystals.setText(crystals.getText().concat(String.valueOf(getNumCrystals())));
        crystalsBox.getChildren().addAll(crystals);

        back = new Button("Return to Game");
        background = new BorderPane();
        background.setBottom(back);
        background.setLeft(weaponsBox);
        background.setCenter(potionsBox);
        background.setRight(crystalsBox);
        maze.setCurr(curr);
        back.setOnAction( e -> {
            primaryStage.setScene(InitialGameScreen.start(primaryStage, maze));
        });
        return new Scene(background, 400, 500);
    }
}