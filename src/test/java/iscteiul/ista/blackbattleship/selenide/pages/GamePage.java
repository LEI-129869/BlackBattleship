package iscteiul.ista.blackbattleship.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class GamePage {

    @FindBy(css = ".btn.btn-outline-dark.d-flex.align-items-center.ng-star-inserted")
    private SelenideElement gameButton;

    @FindBy(css = "div.attack-text")
    private SelenideElement playerTurn;

    @FindBy(xpath = "(//span[contains(concat(' ',@class,' '),' chronometer ')])[1][contains(concat(' ',@class,' '),' bg-secondary ')]")
    private SelenideElement runningClock;

    @FindBy(xpath = "(//table[contains(@class,'table-board')])[2]//td[contains(concat(' ',@class,' '),' cell-4-2 ')]")
    private SelenideElement targetCell;

    @FindBy(xpath = "(//table[contains(@class,'table-board')])[2]//td[contains(concat(' ',@class,' '),' cell-4-2 ')]//*[contains(concat(' ',@class,' '),' no-hit ') or contains(concat(' ',@class,' '),' hit ')]")
    private SelenideElement targetCellResult;

    @Step("Esperar que o jogo seja carregado")
    public GamePage waitForGameToLoad() {
        gameButton.shouldBe(visible);

        return this;
    }

    @Step("Esperar pela vez do jogador")
    public GamePage waitForPlayerTurn() {
        playerTurn.shouldBe(visible, Duration.ofSeconds(30));

        return this;
    }

    @Step("Verificar se é a vez do jogador")
    public boolean isPlayerTurnVisible() {
        return playerTurn.isDisplayed();
    }

    @Step("Verificar se o cronómetro está visível")
    public boolean isRunningClockVisible() {
        return runningClock.isDisplayed();
    }

    @Step("Disparar sobre a célula 4-2")
    public GamePage fireAtCellFourTwo() {
        targetCell.shouldBe(visible).click();
        targetCellResult.should(exist);

        return this;
    }

    @Step("Verificar se a célula 4-2 mostra hit/no-hit")
    public boolean hasShotResult() {
        return targetCellResult.exists();
    }
}