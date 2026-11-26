package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for Selenium IDE scenario.
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object for UserStoryTest6.
 * Encapsulates starting a robot game and checking when it is the player's turn.
 */
public class UserStory6Test {
    private WebDriver driver;
    private UserStory6 page;

    /** Starts a fresh Chrome session before each test. */
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://papergames.io/en/battleship");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement doNotConsent = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.fc-cta-do-not-consent")
                )
        );
        doNotConsent.click();

        page = new UserStory6(driver);
    }

    /** Closes the browser after each test. */
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** Checks that the game chronometer is visible and running after game setup. */
    @Test
    void shouldStartGameWithPlayerTurn() {
        page.openBattleship();
        page.startRobotGame("Teste");
        page.waitForPlayerTurn();

        assertTrue(page.isPlayerTurnVisible(),
                "Deveria ser a vez do jogador atacar.");
    }
}
