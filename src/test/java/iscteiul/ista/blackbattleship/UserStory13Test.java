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
 * JUnit test for UserStoryTest13.
 * Verifies that selecting Español changes the application route to Spanish.
 */
public class UserStory13Test {
    private WebDriver driver;
    private UserStory13 page;

    /** Starts a fresh Chrome session before each test. */
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new UserStory13(driver);
    }

    /** Closes the browser after each test. */
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** Opens Settings, selects Español and checks that the Spanish route is active. */
    @Test
    void shouldChangeApplicationLanguageToSpanish() {
        page.openBattleship();
        page.openSettings();
        page.openLanguageMenu();
        page.selectSpanish();
        assertTrue(page.isSpanishLanguageActive(), "A aplicação deveria estar no idioma espanhol.");
    }
}
