package org.example.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WhoIsScooterForPage extends BasePage {
    //Логотип "Самокат"
    private By logoScooter = By.xpath("//a[@class='Header_LogoScooter__3lsAR']");

    //Тело страницы "Для кого самокат"
    //Поле ввода "Имя"
    private By inputName = By.xpath("//input[@placeholder='* Имя']");
    //Поле ввода "Фамилия"
    private By inputSecondName = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле ввода "Адрес"
    private By inputAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода "Станция метро"
    private By inputStationMetro = By.xpath("//input[@placeholder='* Станция метро']");
    //Поле ввода "Номер телефона"
    private By inputPhoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By fartherButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Поля ввода
    private By inputField = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //Ошибки для полей ввода
    private By errorMessage = By.xpath("//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    //Локатор для снятия фокуса
    private By emptyClick = By.className("Order_Header__BZXOb");

    //Конструктор
    public WhoIsScooterForPage(WebDriver driver) {
        super(driver);
    }

    //Метод ввода значения в поле "Имя"
    public WhoIsScooterForPage insertValueName (String userName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputName));
        driver.findElement(inputName).clear();
        driver.findElement(inputName).sendKeys(userName);
        return this;
    }

    //Метод ввода значения в поле "Фамилия"
    public WhoIsScooterForPage insertValueSecondName (String userSecondName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputSecondName));
        driver.findElement(inputSecondName).clear();
        driver.findElement(inputSecondName).sendKeys(userSecondName);
        return this;
    }

    //Метод ввода значения в поле "Адрес"
    public WhoIsScooterForPage insertValueAddress (String userAddress) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputAddress));
        driver.findElement(inputAddress).clear();
        driver.findElement(inputAddress).sendKeys(userAddress);
        return this;
    }

    //Метод выбора станции метро
    public WhoIsScooterForPage insertValueStationMetro (String stationMetro) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputStationMetro));
        driver.findElement(inputStationMetro).click();
        driver.findElement(By.xpath("//div[contains(@class, " +
                "'select-search__select')]//div[text()='" + stationMetro + "']")).click();
        return this;
    }

    //Метод ввода значения в поле "Телефон"
    public WhoIsScooterForPage insertValueUserPhoneNumber (String userPhoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputPhoneNumber));
        driver.findElement(inputPhoneNumber).clear();
        driver.findElement(inputPhoneNumber).sendKeys(userPhoneNumber);
        return this;
    }

    //Метод нажатия кнопки "Далее"
    public AboutRentPage clickFartherButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fartherButton));
        driver.findElement(fartherButton).click();
        return new AboutRentPage(driver);
    }

    //Метод нажатия на логотип "Самокат"
    public HeaderPage clickLogoScooter() {
        driver.findElement(logoScooter).click();
        return new HeaderPage(driver);
    }

    //Получение всех полей формы заказа у которых есть ошибки
    public List<WebElement> getInputField() {
        return driver.findElements(inputField);
    }

    //Метод ввода текста и снятия фокуса
    public WhoIsScooterForPage setIncorrectData(int index, String text) {
        getInputField().get(index).sendKeys(text);
        driver.findElement(emptyClick).click();
        return this;
    }

    //Метод получения текста ошибки
    public String getErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }
}
