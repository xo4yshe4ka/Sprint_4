package org.example.Objects;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    //конструктор
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
