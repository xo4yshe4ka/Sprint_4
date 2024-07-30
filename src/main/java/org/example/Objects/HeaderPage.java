package org.example.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class HeaderPage extends BasePage{
    //Шапка лендинга
    //Кнопка "Заказать" в шапке лендинга
    private By orderButtonHeader = By.className("Button_Button__ra12g");
    //Логотип "Яндекс"
    private By logoYandex = By.xpath("//a[@class='Header_LogoYandex__3TSOI']");
    //Логотип "Самокат"
    private By logoScooter = By.xpath("//a[@class='Header_LogoScooter__3lsAR']");
    //Кнопка "Статус заказа"
    private By statusOrderButton = By.xpath("//button[@class='Header_Link__1TAG7' and text()='Статус заказа']");
    //Поле для ввода номера заказа
    private By inputNumberOrder = By.xpath("//input[@placeholder='Введите номер заказа']");
    //Кнопка "Go!"
    private By goButton = By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    //метод нажатия на кнопку "Заказать" в шапке лендинга
    public WhoIsScooterForPage clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
        return new WhoIsScooterForPage(driver);
    }

    //Метод нажатия на слово "Яндекс" в логотипе
    public HeaderPage clickLogoYandex() {
        driver.findElement(logoYandex).click();
        return this;
    }

    //Метод перехода на новую страницу
    public HeaderPage goToNewPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    //Метод получения URL страницы
    public String getURL() {
        return driver.getCurrentUrl();
    }

    //Метод нажатия на кнопку "Статус заказа"
    public HeaderPage clickStatusOrderButton() {
        driver.findElement(statusOrderButton).click();
        return this;
    }

    //Метод ввода номера заказа
    public HeaderPage setInputNumberOrder(String numberOrder) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputNumberOrder));
        driver.findElement(inputNumberOrder).sendKeys(numberOrder);
        return this;
    }

    //Метод нажатия на кнопку "Go!"
    public OrderStatusPage clickGoButton() {
        driver.findElement(goButton).click();
        return new OrderStatusPage(driver);
    }
}
