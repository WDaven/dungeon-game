package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static generators.Maze.getPlayer;

public class WinGameScreen {
    private static BorderPane background;
    private static Button restart;
    private static Label complete;
    private static String itemsUsed;
    private static String finalWeapon;
    private static String monstersKilled;
    private static Button closeWindow;
    public static Scene start(Stage primaryStage) {
        background = new BorderPane();
        itemsUsed = String.format("Number of Inventory Items Used: %d\n", Inventory.getNumItemsUsed());
        int i = 0;
        String currWeapon = InitializeConfigScreen.getCurrWeaponList()[i];
        while (InitializeConfigScreen.getCurrWeaponList()[i] != null) {
            currWeapon = InitializeConfigScreen.getCurrWeaponList()[i];
            i++;
        }
        finalWeapon = "Final Weapon: " + currWeapon +"\n";
        monstersKilled = String.format("Number of Monsters Killed: %d\n", MonsterParent.getDeadMonsterCount());
        complete = new Label("YOU WIN! Play again!\n" + itemsUsed + finalWeapon + monstersKilled);

        background.setTop(complete);
        restart = new Button("Start Over");
        closeWindow = new Button("Exit Game");

        restart.setAlignment(Pos.CENTER);
        closeWindow.setAlignment(Pos.CENTER);
        background.setCenter(restart);
        background.setBottom(closeWindow);
        closeWindow.setOnAction(e-> {
            primaryStage.close();
        });
        restart.setOnAction(e -> {
            Inventory.setNumDaggers(0);
            Inventory.setNumSwords(0);
            Inventory.setNumGSwords(0);
            Inventory.setNumAPotion(0);
            Inventory.setNumHPotion(0);
            Inventory.setNumCrystals(0);
            MonsterParent.setDeadMonsterCount(0);
            primaryStage.setScene(InitializeConfigScreen.initConfigScreen(primaryStage));
        });
        getPlayer().setPlayerHealth(100);
        getPlayer().setPlayerDamage(0);
        getPlayer().setCurrAttackNumber(0);
        return new Scene(background, 400, 500);
    }


}