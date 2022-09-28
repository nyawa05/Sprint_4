package service.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderAgreePageYandexSamokat {
    private final WebDriver driver;
    //Заголовок страницы подверждения заказа
    private final By orderAgreePageHeader = new By.ByXPath(".//div[contains(text(),'Хотите оформить заказ?')]");
    //Кнопка подтверждения заказа "Да"
    private final By yesButton = new By.ByXPath(".//button[contains(text(),'Да')]");

    public OrderAgreePageYandexSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void yesButtonClicked() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }

    public void orderAgree() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderAgreePageHeader));
        yesButtonClicked();
    }
}
