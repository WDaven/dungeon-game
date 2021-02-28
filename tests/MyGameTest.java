import Scenes.Main;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import Scenes.initializeConfigScreen;

import static Scenes.InitialGameScreen.getMoney;
import static Scenes.initializeConfigScreen.*;
import static org.testfx.api.FxAssert.verifyThat;

public class MyGameTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main main = new Scenes.Main();
        main.start(primaryStage);
    }
    @Test
    public void testMoneyEasy() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        enterText("testName");
        clickOn("EASY");
        clickOn("WEAPON 1");
        clickOn("CONTINUE");
        FxAssert.verifyThat(getMoney(),LabeledMatchers.hasText("$2000"));
    }

    private void enterText(String s) {
        setUserInputName(s);
    }
    @Test
    public void testMoneyNormal() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        enterText("testName");
        clickOn("NORMAL");
        clickOn("WEAPON 1");
        clickOn("CONTINUE");
        FxAssert.verifyThat(getMoney(),LabeledMatchers.hasText("$1000"));
    }
    @Test
    public void testMoneyHard() {
        clickOn("START GAME");
        clickOn("YOUR NAME HERE");
        clickOn("SET NAME");
        enterText("testName");
        clickOn("HARD");
        clickOn("WEAPON 1");
        clickOn("CONTINUE");
        FxAssert.verifyThat(getMoney(),LabeledMatchers.hasText("$100"));
    }
    


}
