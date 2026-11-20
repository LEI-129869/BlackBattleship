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
 * Page Object for UserStoryTest1.
 * Encapsulates navigation to Battleship and opening the robot-game form.
 */
public class UserStory1 {
    private static final String URL = "https://papergames.io/en/battleship";
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageHeading = By.xpath("//h1[normalize-space()='Battleship Online']");
    private final By playVsRobot = By.xpath("//button[@type='button' and .//span[normalize-space()='Play vs robot']]");
    private final By usernameInput = By.cssSelector("input[formcontrolname='username']");

    /** Creates the page object using the active browser session. */
    public UserStory1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Opens the Battleship page and waits until its main heading is visible. */
    public void openBattleship() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
        pause(400);
    }

    /** Opens the form for playing against the robot. */
    public void openRobotForm() {
        wait.until(ExpectedConditions.elementToBeClickable(playVsRobot)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameInput));
        pause(300);
    }

    /** Returns whether the username input is present in the page. */
    public boolean isUsernameInputPresent() {
        return !driver.findElements(usernameInput).isEmpty();
    }

    /** Waits briefly to make interactions less instantaneous than a script. */
    private void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("A pausa do teste foi interrompida.", exception);
        }
    }
}
