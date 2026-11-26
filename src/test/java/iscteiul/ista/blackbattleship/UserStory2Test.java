package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for Selenium IDE scenario.
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * JUnit test for UserStoryTest2.
 * Verifies that the selected username is shown in the game profile.
 */
public class UserStory2Test {
    private WebDriver driver;
    private UserStory2 page;

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
        page = new UserStory2(driver);
    }

    /** Closes the browser after each test. */
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** Checks that the profile displays the username entered by the player. */
    @Test
    void shouldDisplayEnteredUsernameInProfile() {
        page.openBattleship();
        page.openRobotForm();
        page.enterUsername("Teste");
        page.continueToGame();
        assertEquals("Teste", page.getDisplayedUsername());
    }
}
