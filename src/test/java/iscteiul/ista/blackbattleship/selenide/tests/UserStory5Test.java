package iscteiul.ista.blackbattleship.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide.pages.UserStory5Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit test for UserStoryTest5 (Selenide version).
 * Verifies that firing at opponent-board cell 4-2 produces a visible result.
 */
public class UserStory5Test {

    /** Global Selenide configuration and Allure listener, run once. */
    @BeforeAll
    static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15_000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    /** Closes the browser after each test. */
    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    /** Starts a game, fires at cell 4-2 and checks that a result marker appears. */
    @Test
    @DisplayName("US5 - Disparo na célula 4-2 mostra resultado")
    void shouldShowResultAfterFiringAtCellFourTwo() {
        UserStory5Page userStory5 = page(UserStory5Page.class);
        userStory5.openBattleship()
                .startRobotGame("Teste")
                .waitForPlayerTurn()
                .fireAtCellFourTwo();
        assertTrue(userStory5.hasShotResult(), "O disparo deveria apresentar hit ou no-hit.");
    }
}