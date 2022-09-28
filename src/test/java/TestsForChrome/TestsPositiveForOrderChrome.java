package TestsForChrome;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import service.PageObject.*;
import service.constants.Links;

@RunWith(Parameterized.class)
public class TestsPositiveForOrderChrome {
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);
    private final String newName;
    private final String newSurname;
    private final String newAddress;
    private final String newPhone;
    private final String newMetroStation;
    private final String newDate;
    private final int newPeriod;

    public TestsPositiveForOrderChrome(String newName,
                                       String newSurname,
                                       String newAddress,
                                       String newPhone,
                                       String newMetroStation,
                                       String newDate,
                                       int newPeriod) {
        this.newName = newName;
        this.newSurname = newSurname;
        this.newAddress = newAddress;
        this.newPhone = newPhone;
        this.newMetroStation = newMetroStation;
        this.newDate = newDate;
        this.newPeriod = newPeriod;
    }

    @Parameterized.Parameters
    public static Object[][] getValueFields() {
        return new Object[][]{
                { "Имя", "Фамилия", "Адрес", "12345678901", "Филёвский парк", "27.10.2022", 7 },
                { "Имечко", "Фамилечка", "Адресик", "10987654321", "Петровско-Разумовская", "01.10.2022", 3 },
                { "Тамара", "Тенсина", "Мой адрес", "89825674851", "Славянский бульвар", "11.11.2022", 4 },
        };
    }

    @Test
    public void testPositiveOrderButtonTop() {
        //Полноэкранный режим
        driver.manage().window().maximize();
        //Переходим на сайт
        driver.get(Links.YANDEX_SAMOKAT_LINK);
        //Вызываем конструктор основной страницы
        MainPageYandexSamokat mainPageDriver = new MainPageYandexSamokat(driver);
        //Нажимаем на верхнюю кнопку Заказатть
        mainPageDriver.orderButtonTopClicked();
        //Вызываем конструктор первой страницы заказа
        OrderFirstPageYandexSamokat orderFirstPageDriver = new OrderFirstPageYandexSamokat(driver);
        //Вызываем метод заполнения всех полей первой страницы
        orderFirstPageDriver.enterAllFields(
                newName,
                newSurname,
                newAddress,
                newPhone,
                newMetroStation
        );
        //Вызываем метод нажатия на кнопку Далее
        orderFirstPageDriver.nextButtonClicked();
        //Вызываем конструктор для второй страницы заказа
        OrderSecondPageYandexSamokat orderSecondPageDriver = new OrderSecondPageYandexSamokat(driver);
        //Вызываем метод заполнения обязательных полей второй страницы заказа
        orderSecondPageDriver.enterNecessaryFields(newDate, newPeriod);
        //Вызываем метод нажатия кнопки Заказать
        orderSecondPageDriver.orderButtonClicked();
        //Вызываем конструктор для окна подтверждения заказа
        OrderAgreePageYandexSamokat orderAgreePageDriver = new OrderAgreePageYandexSamokat(driver);
        //Вызываем метод подтверждения заказа
        orderAgreePageDriver.orderAgree();
        //Вызываем контруктор для окна с успешным заказом
        OrderSuccessPageYandexSamokat orderSuccessPageDriver = new OrderSuccessPageYandexSamokat(driver);
        //Вызываем метод проверки успешности заказа
        orderSuccessPageDriver.orderSuccessMessage();
    }

    @Test
    public void testPositiveOrderButtonMiddle() {
        //Полноэкранный режим
        driver.manage().window().maximize();
        //Переходим на сайт
        driver.get(Links.YANDEX_SAMOKAT_LINK);
        //Вызываем конструктор основной страницы
        MainPageYandexSamokat mainPageDriver = new MainPageYandexSamokat(driver);
        //Нажимаем на среднюю кнопку Заказатть
        mainPageDriver.orderButtonMiddleClicked();
        //Вызываем конструктор первой страницы заказа
        OrderFirstPageYandexSamokat orderFirstPageDriver = new OrderFirstPageYandexSamokat(driver);
        //Вызываем метод заполнения всех полей первой страницы
        orderFirstPageDriver.enterAllFields(
                newName,
                newSurname,
                newAddress,
                newPhone,
                newMetroStation
        );
        //Вызываем метод нажатия на кнопку Далее
        orderFirstPageDriver.nextButtonClicked();
        //Вызываем конструктор для второй страницы заказа
        OrderSecondPageYandexSamokat orderSecondPageDriver = new OrderSecondPageYandexSamokat(driver);
        //Вызываем метод заполнения обязательных полей второй страницы заказа
        orderSecondPageDriver.enterNecessaryFields(newDate, newPeriod);
        //Вызываем метод нажатия кнопки Заказать
        orderSecondPageDriver.orderButtonClicked();
        //Вызываем конструктор для окна подтверждения заказа
        OrderAgreePageYandexSamokat orderAgreePageDriver = new OrderAgreePageYandexSamokat(driver);
        //Вызываем метод подтверждения заказа
        orderAgreePageDriver.orderAgree();
        //Вызываем контруктор для окна с успешным заказом
        OrderSuccessPageYandexSamokat orderSuccessPageDriver = new OrderSuccessPageYandexSamokat(driver);
        //Вызываем метод проверки успешности заказа
        orderSuccessPageDriver.orderSuccessMessage();
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
