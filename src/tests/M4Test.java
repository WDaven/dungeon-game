package tests;
import generators.Maze;

import scenes.Main;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.assertTrue;
import static scenes.InitialGameScreen.getCurr;
import static scenes.InitializeConfigScreen.*;
import static org.testfx.api.FxAssert.verifyThat;

public class M4Test extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main main = new scenes.Main();
        main.start(primaryStage);
    }
    @Test
    public void monsterHPDecrease() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int monsterHp = getCurr().getMonster().getMonsterHealth();
        clickOn("Attack!");
        int newMonsterHp = getCurr().getMonster().getMonsterHealth();
        assertTrue(newMonsterHp < monsterHp);
    }

    @Test
    public void playerHPDecrease() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int playerHp = Maze.getPlayer().getPlayerHealth();
        clickOn("Attack!");
        int newPlayerHp = Maze.getPlayer().getPlayerHealth();
        assertTrue(newPlayerHp < playerHp);
    }
    @Test
    public void monsterMarkedDead() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int monsterHp = getCurr().getMonster().getMonsterHealth();
        clickOn("Attack!");
        while (monsterHp > 0) {
            clickOn("Attack!");
            monsterHp = getCurr().getMonster().getMonsterHealth();
        }
        assertTrue(getCurr().getMonster().getMonsterIsDead());
    }

    @Test
    public void deadMonsterDisappears() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int monsterHp = getCurr().getMonster().getMonsterHealth();
        clickOn("Attack!");
        while (monsterHp > 0) {
            clickOn("Attack!");
            monsterHp = getCurr().getMonster().getMonsterHealth();
        }
        verifyThat("Attack1!", NodeMatchers.isInvisible());
    }
    @Test
    public void playerDamageOne() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        assertTrue(Maze.getPlayer().getPlayerDamage() == 8);
    }

    @Test
    public void playerDamageTwo() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon2());
        clickOn("CONTINUE");
        assertTrue(Maze.getPlayer().getPlayerDamage() == 10);
    }

    @Test
    public void playerDamageThree() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon3());
        clickOn("CONTINUE");
        assertTrue(Maze.getPlayer().getPlayerDamage() == 12);
    }
    @Test
    public void playerDamageMonsterHpChange() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int monsterHp = getCurr().getMonster().getMonsterHealth();
        clickOn("Attack!");
        int newMonsterHp = getCurr().getMonster().getMonsterHealth();
        assertTrue(newMonsterHp == monsterHp - 8);
    }
    @Test
    public void playerOnDeathRestart() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        getCurr().getMonster().setMonsterDamage(100);
        getCurr().getMonster().setMonsterHealth(100);
        clickOn("Attack!");
        verifyThat("Game Over. Please try again...", NodeMatchers.isVisible());
    }
    @Test
    public void continueAliveMonster() {
        Maze.setRandExitRoomSet(true);
        Maze.setRandExitRoom(4);
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        write("testName");
        clickOn("HARD");
        clickOn(getWeapon1());
        clickOn("CONTINUE");
        clickOn("Exit Right");
        int currRoom = getCurr().getRoomIdentifier();
        clickOn("Exit Right");
        int nextRoom = getCurr().getRoomIdentifier();
        assertTrue(currRoom == nextRoom);
    }
}