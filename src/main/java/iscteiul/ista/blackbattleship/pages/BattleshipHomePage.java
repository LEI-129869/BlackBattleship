
package iscteiul.ista.blackbattleship.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BattleshipHomePage {

    private static final String URL =
            "https://papergames.io/en/battleship";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageHeading =
            By.xpath("//h1[normalize-space()='Battleship Online']");

    private final By playVsRobot =
            By.xpath("//button[@type='button' and .//span[normalize-space()='Play vs robot']]");

    public BattleshipHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get(URL);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageHeading)
        );
    }

    public void clickPlayVsRobot() {
        wait.until(
                ExpectedConditions.elementToBeClickable(playVsRobot)
        ).click();
    }
}
