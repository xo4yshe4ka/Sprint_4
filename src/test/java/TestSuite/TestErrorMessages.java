package TestSuite;

import org.example.Objects.HeaderPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestErrorMessages extends BaseTest {
    //Номер поля
    private final int index;
    //Текст ввода в поле
    private final String text;
    //Ожидаемый текст ошибки
    private final String expectedErrorText;

    public TestErrorMessages(int index, String text, String expectedErrorText) {
        this.index = index;
        this.text = text;
        this.expectedErrorText = expectedErrorText;

    }
    @Parameterized.Parameters
    public static Object[][] expectedText() {
        return new Object[][] {
                {0, "Bob", "Введите корректное имя"},
                {1, "Bob", "Введите корректную фамилию"},
                {2, "Bob", "Введите корректный адрес"},
                {3, "Bob", "Введите корректный номер"},
        };
    }

    @Test
    public void test() {
        String actualErrorText = new HeaderPage(driver)
                .clickOrderButtonHeader()//клик по кнопке "Заказать" в шапке
                .setIncorrectData(index, text)//ввод текста и снятие фокуса
                .getErrorMessage();//получение текста ошибки
        Assert.assertEquals("Текст ошибки не соответствует требованиям", expectedErrorText, actualErrorText);

    }
}
