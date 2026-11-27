
package iscteiul.ista.blackbattleship.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GamePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By gameButton =
            By.cssSelector(".btn.btn-outline-dark.d-flex.align-items-center.ng-star-inserted");

    private final By runningClock =
            By.xpath("(//span[contains(concat(' ',@class,' '),' chronometer ')])[1][contains(concat(' ',@class,' '),' bg-secondary ')]");

    private final By playerTurn =
            By.cssSelector("div.attack-text");

    private final By targetCell =
            By.xpath("(//table[contains(@class,'table-board')])[2]//td[contains(concat(' ',@class,' '),' cell-4-2 ')]");

    private final By targetCellResult =
            By.xpath("(//table[contains(@class,'table-board')])[2]//td[contains(concat(' ',@class,' '),' cell-4-2 ')]//*[contains(concat(' ',@class,' '),' no-hit ') or contains(concat(' ',@class,' '),' hit ')]");

    public GamePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForGameToLoad() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(gameButton)
        );
    }

    public void waitForPlayerTurn() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(playerTurn)
        );
    }

    public boolean isPlayerTurnVisible() {
        return !driver.findElements(playerTurn).isEmpty()
                && driver.findElement(playerTurn).isDisplayed();
    }

    public boolean isRunningClockVisible() {
        return !driver.findElements(runningClock).isEmpty()
                && driver.findElement(runningClock).isDisplayed();
    }

    public void fireAtCellFourTwo() {
        wait.until(
                ExpectedConditions.elementToBeClickable(targetCell)
        ).click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(targetCellResult)
        );
    }

    public boolean hasShotResult() {
        return !driver.findElements(targetCellResult).isEmpty();
    }
}
