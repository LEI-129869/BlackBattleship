package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

/**
 * Page Object for Selenium IDE scenario.
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * JUnit test for UserStoryTest1.
 * Verifies that the robot-game form exposes the username field.
 */
public class UserStory1Test {
    private WebDriver driver;
    private UserStory1 page;

    /** Starts a fresh Chrome session before each test. */
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new UserStory1(driver);
    }

    /** Closes the browser after each test. */
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** Checks that opening the robot form makes the username field available. */
    @Test
    void shouldDisplayUsernameFieldWhenPlayingAgainstRobot() {
        page.openBattleship();
        page.openRobotForm();
        assertTrue(page.isUsernameInputPresent(), "O campo username deveria estar presente.");
    }
}
