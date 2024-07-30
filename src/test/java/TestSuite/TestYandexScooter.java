package TestSuite;

import org.example.Objects.HeaderPage;
import org.junit.Assert;
import org.junit.Test;

public class TestYandexScooter extends BaseTest {

    //Тест на проверку открытия главной страницы Яндекса при клике на логотип "Яндекс"
    @Test
    public void testLogoYandex() {
        String expectedURL = "https://ya.ru/";
        String resultURL = new HeaderPage(driver)
                .clickLogoYandex()//клик по лого "Яндекс"
                .goToNewPage()//Переход на новую страницу
                .getURL();//Получение URL страницы
        Assert.assertEquals("Открылась не главная страница Яндекса", expectedURL, resultURL);
    }

    //Тест на проверку перехода на страницу лендинга "ЯндексСамокат" при клике на логотип "Самоката"
    @Test
    public void testLogoScooter() {
        String expectedURL = "https://qa-scooter.praktikum-services.ru/";
        String resultURL = new HeaderPage(driver)
                .clickOrderButtonHeader()//клик по кнопке "Заказать"
                .clickLogoScooter()//клик по логотипу "Самокат"
                .getURL();//Получение URL страницы
        Assert.assertEquals("Главная страница ЯндексСамоката не открылась", expectedURL, resultURL);
    }

    //Тест на ввод неправильного номера заказа
    @Test
    public void enterIncorrectNumber() {
        String incorrectOrderNumber = "152985";
        Boolean result = new HeaderPage(driver)
                .clickStatusOrderButton()//клик на кнопку "Статус заказа"
                .setInputNumberOrder(incorrectOrderNumber)//ввод номера заказа
                .clickGoButton()//клик на кнопку "Go!"
                .isImageDisplayed();//проверка, что отображается изображение "Такого заказа нет"
        Assert.assertTrue(result);
    }
}
