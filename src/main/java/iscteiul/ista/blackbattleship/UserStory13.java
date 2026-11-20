package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object for Selenium IDE scenario.
 */
/**
 * Page Object for UserStoryTest13.
 * Encapsulates opening Settings and changing the interface language to Spanish.
 */
public class UserStory13 {
    private static final String URL = "https://papergames.io/en/battleship";
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageHeading = By.xpath("//h1[normalize-space()='Battleship Online']");
    private final By settingsButton = By.xpath("//button[@mattooltip='Settings']");
    private final By settingsHeader = By.xpath("//header[.//h2[normalize-space()='Settings']]");
    private final By languageMenuButton = By.cssSelector("button.mat-mdc-menu-trigger[aria-haspopup='menu']");
    private final By menu = By.cssSelector("div[role='menu']");
    private final By spanishOption = By.xpath("//div[@role='menu']//button[@role='menuitem'][.//span[normalize-space()='Español']]");

    /** Creates the page object using the active browser session. */
    public UserStory13(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Opens Battleship and waits for the main heading. */
    public void openBattleship() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
        pause(400);
    }

    /** Opens the Settings panel. */
    public void openSettings() {
        wait.until(ExpectedConditions.elementToBeClickable(settingsButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsHeader));
        pause(350);
    }

    /** Opens the language menu inside Settings. */
    public void openLanguageMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(languageMenuButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(menu));
        pause(250);
    }

    /** Selects Spanish from the language menu. */
    public void selectSpanish() {
        wait.until(ExpectedConditions.elementToBeClickable(spanishOption)).click();
        wait.until(driver -> driver.getCurrentUrl().contains("/es/"));
        pause(500);
    }

    /** Returns whether the current URL indicates the Spanish-language route. */
    public boolean isSpanishLanguageActive() {
        return driver.getCurrentUrl().contains("/es/");
    }

    /** Waits briefly to simulate a human interaction pause. */
    private void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("A pausa do teste foi interrompida.", exception);
        }
    }
}
