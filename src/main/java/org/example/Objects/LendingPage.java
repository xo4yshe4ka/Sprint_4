package org.example.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LendingPage extends BasePage{

    //Тело лендинга
    //Кнопка "Заказать" в теле лендинга
    private By orderButtonBody = By.className("Button_Middle__1CSJM");
    //Кнопки выпадающего списка вопросов
    private By accordionButtons = By.xpath("//div[contains(@class, 'accordion__button')]");
    //Локатор для текста ответа выпадающего списка
    private By accordionPanelAnswerQuestion = By.xpath("//div[contains(@class, accordion__panel)]/p");

    public LendingPage(WebDriver driver) {
        super(driver);
    }

    //Получение всех кнопок выпадающего списка
    public List<WebElement> getAccordionButtons() {
        return driver.findElements(accordionButtons);
    }

    //Получение всех текстов ответов выпадающего списка
    public List<WebElement> getAccordionPanel() {
        return driver.findElements(accordionPanelAnswerQuestion);
    }

    //Метод нажатия на кнопку выпадающего списка
    public LendingPage clickAccordionButtons(int index) {
        WebElement element = driver.findElement(accordionButtons);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        getAccordionButtons().get(index).click();
        return this;
    }

    //Метод получения текста выпадающего списка
    public String getAccordionPanelText(int index) {
        return getAccordionPanel().get(index).getText();
    }

    //метод нажатия на кнопку "Заказать" в теле лендинга
    public WhoIsScooterForPage clickOrderButtonBody() {
        WebElement element = driver.findElement(orderButtonBody);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonBody).click();
        return new WhoIsScooterForPage(driver);
    }
}
