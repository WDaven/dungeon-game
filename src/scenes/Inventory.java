package scenes;

import generators.Maze;
import generators.Maze.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static generators.Maze.getPlayer;

public class Inventory {
    private static BorderPane background;
    private static Button back;
    private static Label weapons;
    private static int numDaggers;
    private static Button daggers;
    private static Button swords;
    private static Button greatSwords;
    private static int numSwords;
    private static int numGSwords;
    private static Label potions;
    private static Button hPotion;
    private static Button aPotion;
    private static int numHPotion;
    private static int numAPotion;
    private static Button crystals;
    private static int numCrystals;
    private static int numItemsUsed;

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
    public static int getNumItemsUsed() {
        return numItemsUsed;
    }

    public static Scene start(Stage primaryStage, Maze maze, Node curr) {
        // weapons vbox
        VBox weaponsBox = new VBox(10);
        weapons = new Label("Weapons:");
        daggers = new Button("Daggers: ");
        swords = new Button("Swords: ");
        greatSwords = new Button("Great Swords: ");
        daggers.setText(daggers.getText().concat(String.valueOf(getNumDaggers())));
        swords.setText(swords.getText().concat(String.valueOf(getNumSwords())));
        greatSwords.setText(greatSwords.getText().concat(String.valueOf(getNumGSwords())));
        weaponsBox.getChildren().addAll(weapons, daggers, swords, greatSwords);

        daggers.setOnAction(e -> {
            if (numDaggers > 0) {
                numDaggers--;
                numItemsUsed++;
                getPlayer().setPlayerDamage(8);
                if (getPlayer().getCurrAttackNumber() > 0) {
                    getPlayer().setPlayerDamage(getPlayer().getPlayerDamage() + 10);
                }
            }
            daggers.setText("Daggers: ".concat(String.valueOf(getNumDaggers())));
        });
        swords.setOnAction(e -> {
            if (numSwords > 0) {
                numSwords--;
                numItemsUsed++;
                getPlayer().setPlayerDamage(10);
                if (getPlayer().getCurrAttackNumber() > 0) {
                    getPlayer().setPlayerDamage(getPlayer().getPlayerDamage() + 10);
                }
            }
            swords.setText("Swords: ".concat(String.valueOf(getNumSwords())));
        });
        greatSwords.setOnAction(e -> {
            if (numGSwords > 0) {
                numGSwords--;
                numItemsUsed++;
                getPlayer().setPlayerDamage(12);
                if (getPlayer().getCurrAttackNumber() > 0) {
                    getPlayer().setPlayerDamage(getPlayer().getPlayerDamage() + 10);
                }
            }
            greatSwords.setText("Great Swords: ".concat(String.valueOf(getNumGSwords())));
        });

        // potions box
        VBox potionsBox = new VBox(10);
        potions = new Label("Potions: ");
        hPotion = new Button("Health Potions: ");
        aPotion = new Button("Attack Potions: ");
        hPotion.setText(hPotion.getText().concat(String.valueOf(getNumHPotion())));
        aPotion.setText(aPotion.getText().concat(String.valueOf(getNumAPotion())));
        potionsBox.getChildren().addAll(potions, hPotion, aPotion);

        hPotion.setOnAction(e -> {
            if (numHPotion > 0) {
                numHPotion--;
                numItemsUsed++;
                getPlayer().setPlayerHealth(getPlayer().getPlayerHealth() + 20);
            }
            hPotion.setText("Health Potions: ".concat(String.valueOf(getNumHPotion())));
        });
        aPotion.setOnAction(e -> {
            if (numAPotion > 0) {
                numAPotion--;
                numItemsUsed++;
                getPlayer().setPlayerDamage(getPlayer().getPlayerDamage() + 10);
                getPlayer().setCurrAttackNumber(5);
            }
            aPotion.setText("Attack Potions: ".concat(String.valueOf(getNumAPotion())));
        });

        // crystals box
        VBox crystalsBox = new VBox(10);
        crystals = new Button("Magic Crystals: ");
        crystals.setText(crystals.getText().concat(String.valueOf(getNumCrystals())));
        crystalsBox.getChildren().addAll(crystals);

        crystals.setOnAction(e -> {
            if (numCrystals > 0) {
                numCrystals--;
                numItemsUsed++;
                primaryStage.setScene(GameOver.start(primaryStage));
            }
            crystals.setText("Magic Crystals: ".concat(String.valueOf(getNumCrystals())));
        });

        back = new Button("Return to Game");
        background = new BorderPane();
        background.setBottom(back);
        background.setLeft(weaponsBox);
        background.setCenter(potionsBox);
        background.setRight(crystalsBox);
        maze.setCurr(curr);
        back.setOnAction(e -> {
            primaryStage.setScene(InitialGameScreen.start(primaryStage, maze));
            if (curr.getMonster().getMonsterIsDead()) {
                InitialGameScreen.hideMonster();
                InitialGameScreen.getMonsterStatus().setText("Monster Health: Dead");
            }
        });
        return new Scene(background, 400, 500);

    }
}