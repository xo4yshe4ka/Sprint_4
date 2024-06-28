package org.example.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage extends BasePage{
    //Изображение "Такого заказа нет"
    private By orderNotFoundImage = By.className("Track_NotFound__6oaoY");

    public OrderStatusPage(WebDriver driver) {
        super(driver);
    }

    //Метод для проверки отображения изображения "Такого заказа нет"
    public Boolean isImageDisplayed() {
        return driver.findElement(orderNotFoundImage).isDisplayed();
    }
}
