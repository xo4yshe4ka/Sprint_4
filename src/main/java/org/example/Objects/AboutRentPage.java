package org.example.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRentPage extends BasePage {
    //Поле ввода "Когда привезти самокат"
    private By inputDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Поле ввода "Срок аренды"
    private By inputRentalPeriod = By.xpath("//div[text()='* Срок аренды']");
    //Чек-бокс "чёрный жемчуг"
    private By checkBoxBlackPearls = By.id("black");
    //Чек-бокс "серая безысходность"
    private By checkBoxGrayDespair = By.id("grey");
    //Поле ввода "Комментарий для курьера"
    private By inputComment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutRentPage(WebDriver driver) {
        super(driver);
    }

    //Метод передачи значения в пола "Дата"
    public AboutRentPage insertDate(String date) {
        driver.findElement(inputDate).clear();
        driver.findElement(inputDate).sendKeys(date);
        driver.findElement(inputDate).sendKeys(Keys.ENTER);
        return this;
    }

    //Метод выбора срока аренды
    public AboutRentPage insertRentalPeriod(String rentalPeriod){
        driver.findElement(inputRentalPeriod).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '" + rentalPeriod + "') and contains(@class, 'Dropdown-option')]")));
        driver.findElement(By.xpath("//div[contains(text(), '" + rentalPeriod + "') and contains(@class, 'Dropdown-option')]")).click();
        return this;
    }

    //Метод выбора цвета самоката
    public AboutRentPage checkBoxColour(String colour) {
        switch (colour) {
            case "чёрный жемчуг":
                driver.findElement(checkBoxBlackPearls).click();
                break;
            case "серая безысходность":
                driver.findElement(checkBoxGrayDespair).click();;
                break;
            case "чёрный жемчуг, серая безысходность":
                driver.findElement(checkBoxBlackPearls).click();;
                driver.findElement(checkBoxGrayDespair).click();;
                break;
            case "":
                break;
        }
        return this;
    }

    //Метод ввода значения в поле "Комментарий для курьера"
    public AboutRentPage insertComment(String commentForCourier) {
        driver.findElement(inputComment).clear();
        driver.findElement(inputComment).sendKeys(commentForCourier);
        return this;
    }

    //Метод нажатия кнопки "Заказать"
    public YouWantMakeOrderPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return new YouWantMakeOrderPage(driver);
    }
}
