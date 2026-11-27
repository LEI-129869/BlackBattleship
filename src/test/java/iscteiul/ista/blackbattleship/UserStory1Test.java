package iscteiul.ista.blackbattleship;

import iscteiul.ista.blackbattleship.pages.BattleshipHomePage;
import iscteiul.ista.blackbattleship.pages.RobotGamePage;

import iscteiul.ista.blackbattleship.pages.SettingsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory1Test {

    private WebDriver driver;

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
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldOpenRobotGameForm() {

        BattleshipHomePage homePage =
                new BattleshipHomePage(driver);

        RobotGamePage robotGamePage =
                new RobotGamePage(driver);

        homePage.open();
        homePage.clickPlayVsRobot();

        assertTrue(robotGamePage.isUsernameInputPresent());
    }
}