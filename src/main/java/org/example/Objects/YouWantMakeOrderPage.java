package org.example.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YouWantMakeOrderPage extends BasePage {

    //Кнопка "Да"
    private By yesButton = By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']");

    public YouWantMakeOrderPage(WebDriver driver) {
        super(driver);
    }

    //Метод нажатия на кнопку "Да"
    public OrderPlacedPage clickYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        driver.findElement(yesButton).click();
        return new OrderPlacedPage(driver);
    }
}
