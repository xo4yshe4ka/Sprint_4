package org.example.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPlacedPage extends BasePage {

    //Кнопка "Посмотреть статус"
    private By viewStatusButton = By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM')" +
            " and contains(text(), 'Посмотреть статус')]");

    public OrderPlacedPage(WebDriver driver) {
        super(driver);
    }

    //Метод для проверки отображения кнопки "Посмотреть статус"
    public boolean checkViewStatusButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(viewStatusButton));

        return driver.findElement(viewStatusButton).isDisplayed();
    }
}
