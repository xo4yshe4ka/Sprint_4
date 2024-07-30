package TestSuite;

import org.example.Objects.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestOrderScooter extends BaseTest {

    private final String userName;
    private final String userSecondName;
    private final String userAddress;
    private final String stationMetro;
    private final String userPhoneNumber;

    private final String date;
    private final String rentalPeriod;
    private final String colour;
    private final String commentForCourier;
    private final boolean expected;

    public TestOrderScooter(String userName, String userSecondName, String userAddress, String stationMetro,
                            String userPhoneNumber, String date, String rentalPeriod, String colour,
                            String commentForCourier, boolean expected) {
        this.userName = userName;
        this.userSecondName = userSecondName;
        this.userAddress = userAddress;
        this.stationMetro = stationMetro;
        this.userPhoneNumber = userPhoneNumber;

        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.commentForCourier = commentForCourier;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderScooter() {
        return new Object[][]{
                { "Ольга", "Петрова", "Москва Коштоянца 7", "Бульвар Рокоссовского", "89998887766",
                "26.06.2024", "сутки", "чёрный жемчуг, серая безысходность", "коммент", true},
                { "Василиса", "Васильева", "Москва Энгельса 7", "Автозаводская", "+79998887766",
                "28.06.2024", "двое суток", "серая безысходность", "", true},
                };
    }

    @Test
    public void checkOrderForButtonHeader() {
        Boolean result = new HeaderPage(driver)
                .clickOrderButtonHeader()//нажатие кнопки "Заказать" в шапке лендинга
                .insertValueName(userName)//ввод имени
                .insertValueSecondName(userSecondName)//ввод фамилии
                .insertValueAddress(userAddress)//ввод адреса
                .insertValueStationMetro(stationMetro)//выбор станции метро
                .insertValueUserPhoneNumber(userPhoneNumber)//ввод номера телефона
                .clickFartherButton()//нажатие кнопки "Далее"
                .insertDate(date)//ввод даты
                .insertRentalPeriod(rentalPeriod)//ввод срока аренды
                .checkBoxColour(colour)//выбор цвета самоката
                .insertComment(commentForCourier)//ввод комментария для курьера
                .clickOrderButton()//нажатеи кнопки "Заказать"
                .clickYesButton()//Нажатие кнопки "Да"
                .checkViewStatusButton();//проверка отображения кнопки "Посмотреть статус"

        Assert.assertEquals("Заказ не оформлен", expected, result);


    }

    @Test
    public void checkOrderForButtonBody(){
        Boolean result = new LendingPage(driver)
                .clickOrderButtonBody()//нажатие кнопик "Заказать" в теле лендинга
                .insertValueName(userName)//ввод имени
                .insertValueSecondName(userSecondName)//ввод фамилии
                .insertValueAddress(userAddress)//ввод адреса
                .insertValueStationMetro(stationMetro)//выбор станции метро
                .insertValueUserPhoneNumber(userPhoneNumber)//ввод номера телефона
                .clickFartherButton()//нажатие кнопки "Далее"
                .insertDate(date)//ввод даты
                .insertRentalPeriod(rentalPeriod)//ввод срока аренды
                .checkBoxColour(colour)//выбор цвета самоката
                .insertComment(commentForCourier)//ввод комментария для курьера
                .clickOrderButton()//нажатеи кнопки "Заказать"
                .clickYesButton()//Нажатие кнопки "Да"
                .checkViewStatusButton();//проверка отображения кнопки "Посмотреть статус"

        Assert.assertEquals("Заказ не оформлен", expected, result);
    }
}
