package TestsForChrome;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.PageObject.MainPageYandexSamokat;
import service.constants.Links;
import service.constants.Xpath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestsPositiveForQuestionsChrome {
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);

    private final By question;
    private final By answerRegion;
    private final By answer;
    private final String expected;


    public TestsPositiveForQuestionsChrome(int idRow, String expected) {
            this.question = By.xpath(String.format(Xpath.XPATH_FOR_QUESTION, idRow));
            this.answer = By.xpath(String.format(Xpath.XPATH_FOR_ANSWER, idRow));
            this.answerRegion = By.xpath(String.format(Xpath.XPATH_FOR_ANSWER_REGION, idRow));
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getQuestions() {
            return new Object[][]{
                    //Вопрос - Сколько это стоит? И как оплатить?
                    {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    //Вопрос - Хочу сразу несколько самокатов! Так можно?
                    {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    //Вопрос - Как рассчитывается время аренды?
                    {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    //Вопрос - Можно ли заказать самокат прямо на сегодня?
                    {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    //Вопрос - Можно ли продлить заказ или вернуть самокат раньше?
                    {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    //Вопрос - Вы привозите зарядку вместе с самокатом?
                    {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    //Вопрос - Можно ли отменить заказ?
                    {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    //Вопрос - Я жизу за МКАДом, привезёте?
                    {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void questionsTest() {
        //Полноэкранный режим
        driver.manage().window().maximize();
        //Переходим на сайт
        driver.get(Links.YANDEX_SAMOKAT_LINK);
        //Скролл до тестируемого вопроса
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(question));
        //Вызываем конструктор
        MainPageYandexSamokat mainPageDriver = new MainPageYandexSamokat(driver, answer, question, answerRegion);
        //Нажимаем на кнопку с вопросом
        mainPageDriver.questionButtonClicked();
        //Ожидаем пока раскроется ответ
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(answerRegion));
        //Проверяем открялся ли ответ
        assertTrue("После нажатия на вопрос - не раскрылось поле с ответом", mainPageDriver.isVisible());
        //Проверяем ответ с ожидаемым результатом
        assertEquals("Текст ответа не соответствует ожидаемому", expected, mainPageDriver.getAnswer());
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
