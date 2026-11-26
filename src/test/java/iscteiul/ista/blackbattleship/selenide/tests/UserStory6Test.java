package iscteiul.ista.blackbattleship.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide.pages.UserStory6Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit test for UserStoryTest6 (Selenide version).
 * Verifies that the game starts with the player's turn to attack.
 */
public class UserStory6Test {

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

    /** Checks that the player's turn indicator is visible after game setup. */
    @Test
    @DisplayName("US6 - Jogo arranca com a vez do jogador")
    void shouldStartGameWithPlayerTurn() {
        UserStory6Page userStory6 = page(UserStory6Page.class);
        userStory6.openBattleship()
                .startRobotGame("Teste")
                .waitForPlayerTurn();
        assertTrue(userStory6.isPlayerTurnVisible(), "Deveria ser a vez do jogador atacar.");
    }
}