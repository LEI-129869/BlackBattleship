package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

/**
 * JUnit test for UserStoryTest5.
 * Verifies that firing at opponent-board cell 4-2 produces a visible result.
 */
public class UserStory5Test {
    private WebDriver driver;
    private UserStory5 page;

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

        page = new UserStory5(driver);
    }

    /** Closes the browser after each test. */
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** Starts a game, fires at cell 4-2 and checks that a result marker appears. */
    @Test
    void shouldShowResultAfterFiringAtCellFourTwo() {
        page.openBattleship();
        page.startRobotGame("Teste");
        page.waitForPlayerTurn();

        page.fireAtCellFourTwo();

        assertTrue(page.hasShotResult(),
                "O disparo deveria apresentar hit ou no-hit.");
    }
}