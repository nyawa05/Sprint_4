package service.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageYandexSamokat {
    private final WebDriver driver;
    private By question;
    private By answerRegion;
    private By answer;
    //Кнопка "Заказать" наверху основной страницы
    private final By orderButtonTop = By.className("Button_Button__ra12g");
    //Кнопка "Заказать" в середине основной страницы
    private final By orderButtonMiddle = new By.ByXPath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //Конструктор для тестирования параметрического теста
    public MainPageYandexSamokat(WebDriver driver, By answer, By question, By answerRegion) {
        this.driver = driver;
        this.answer = answer;
        this.question = question;
        this.answerRegion = answerRegion;
    }
    //Конструктор для тестирования заказа
    public MainPageYandexSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void questionButtonClicked () {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(question));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(question)).click();
    }

    public boolean isVisible () {
        return driver.findElement(answerRegion).isDisplayed();
    }

    public String getAnswer () {
        return driver.findElement(answer).getText();
    }

    public void orderButtonTopClicked () {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderButtonTop)).click();
    }

    public void orderButtonMiddleClicked () {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(orderButtonMiddle));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderButtonMiddle)).click();
    }
}
