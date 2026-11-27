package iscteiul.ista.blackbattleship.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import iscteiul.ista.blackbattleship.selenide.pages.BattleshipHomePage;
import iscteiul.ista.blackbattleship.selenide.pages.RobotGamePage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserStory2Test {

    @BeforeAll
    static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("US2 - Username introduzido aparece no perfil")
    void shouldDisplayEnteredUsernameInProfile() {

        BattleshipHomePage homePage = page(BattleshipHomePage.class);
        RobotGamePage robotGamePage = page(RobotGamePage.class);

        homePage.openBattleship()
                .clickPlayVsRobot();

        robotGamePage.enterUsername("Teste")
                .continueToGame();

        assertEquals(
                "Teste",
                robotGamePage.getDisplayedUsername()
        );
    }
}