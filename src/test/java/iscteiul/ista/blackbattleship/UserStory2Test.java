package iscteiul.ista.blackbattleship;

import iscteiul.ista.blackbattleship.pages.BattleshipHomePage;
import iscteiul.ista.blackbattleship.pages.RobotGamePage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserStory2Test {

    private WebDriver driver;

    private BattleshipHomePage homePage;
    private RobotGamePage robotGamePage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://papergames.io/en/battleship");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement doNotConsent = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.fc-cta-consent")
                )
        );

        doNotConsent.click();

        homePage = new BattleshipHomePage(driver);
        robotGamePage = new RobotGamePage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void shouldDisplayEnteredUsernameInProfile() {

        homePage.open();
        homePage.clickPlayVsRobot();

        robotGamePage.enterUsername("Teste");
        robotGamePage.continueToGame();

        assertEquals(
                "Teste",
                robotGamePage.getDisplayedUsername()
        );
    }
}