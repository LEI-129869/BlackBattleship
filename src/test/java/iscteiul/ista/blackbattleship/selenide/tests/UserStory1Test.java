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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory1Test {

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
    @DisplayName("US1 - Campo username visível ao jogar contra o robot")
    void shouldDisplayUsernameFieldWhenPlayingAgainstRobot() {

        BattleshipHomePage homePage = page(BattleshipHomePage.class);
        RobotGamePage robotGamePage = page(RobotGamePage.class);

        homePage.openBattleship()
                .clickPlayVsRobot();

        assertTrue(
                robotGamePage.isUsernameInputPresent(),
                "O campo username deveria estar presente."
        );
    }
}