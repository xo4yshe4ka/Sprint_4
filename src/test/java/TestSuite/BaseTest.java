package TestSuite;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    private final static String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.get(BASE_URL);
        Cookie newCookie = new Cookie("Cartoshka", "true");
        driver.manage().addCookie(newCookie);
        Cookie newCookie2 = new Cookie("Cartoshka-legacy", "true");
        driver.manage().addCookie(newCookie2);
        driver.navigate().refresh();
    }

    /*@Before
    public void setUp() {
        driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.get(BASE_URL);
        Cookie newCookie = new Cookie("Cartoshka", "true");
        driver.manage().addCookie(newCookie);
        Cookie newCookie2 = new Cookie("Cartoshka-legacy", "true");
        driver.manage().addCookie(newCookie2);
        driver.navigate().refresh();
    }*/

    @After
    public void tearDown() {
        driver.quit();
    }
}
