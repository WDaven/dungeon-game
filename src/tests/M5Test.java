package tests;
import generators.Maze;

import scenes.Inventory;
import scenes.Main;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import scenes.Player;

import static org.junit.Assert.assertTrue;
import static scenes.InitialGameScreen.getCurr;
import static scenes.InitializeConfigScreen.*;
import static org.testfx.api.FxAssert.verifyThat;

public class M5Test extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main main = new scenes.Main();
        main.start(primaryStage);
    }
    @Test
    public void attackPotionDamage() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int priorDamage = Maze.getPlayer().getPlayerDamage();
        Inventory.setNumAPotion(2);
        clickOn("Inventory");
        clickOn("Attack Potions: 2");
        clickOn("Return to Game");
        assertTrue(priorDamage == Maze.getPlayer().getPlayerDamage() - 10);
    }
    @Test
    public void healthPotionHeal() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int priorHealth = Maze.getPlayer().getPlayerHealth();
        Inventory.setNumHPotion(2);
        clickOn("Inventory");
        clickOn("Health Potions: 2");
        clickOn("Return to Game");
        assertTrue(priorHealth == Maze.getPlayer().getPlayerHealth() - 20);
    }
    @Test
    public void magicCrystalLoose() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int priorHealth = Maze.getPlayer().getPlayerHealth();
        Inventory.setNumCrystals(2);
        clickOn("Inventory");
        clickOn("Magic Crystals: 2");
        verifyThat("Game Over. Please try again...", NodeMatchers.isVisible());
    }
    @Test
    public void weaponChoice1() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        Inventory.setNumDaggers(2);
        clickOn("Inventory");
        clickOn("Daggers: 2");
        clickOn("Return to Game");
        assertTrue(Maze.getPlayer().getPlayerDamage() == 8);
    }
    @Test
    public void weaponChoice2() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        Inventory.setNumSwords(2);
        clickOn("Inventory");
        clickOn("Swords: 2");
        clickOn("Return to Game");
        assertTrue(Maze.getPlayer().getPlayerDamage() == 10);
    }
    @Test
    public void weaponChoice3() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        Inventory.setNumGSwords(2);
        clickOn("Inventory");
        clickOn("Great Swords: 2");
        clickOn("Return to Game");
        assertTrue(Maze.getPlayer().getPlayerDamage() == 12);
    }
    @Test
    public void attackPotionTemporary() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int priorDamage = Maze.getPlayer().getPlayerDamage();
        Inventory.setNumAPotion(2);
        clickOn("Inventory");
        clickOn("Attack Potions: 2");
        clickOn("Return to Game");
        Maze.getCurr().getMonster().setMonsterHealth(500);
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        clickOn("Attack!");
        assertTrue(Maze.getPlayer().getPlayerDamage() == priorDamage);
    }




}