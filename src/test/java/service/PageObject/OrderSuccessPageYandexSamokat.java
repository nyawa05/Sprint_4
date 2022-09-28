package service.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSuccessPageYandexSamokat {
    private final WebDriver driver;
    //Заголовок успешного заказа
    private final By orderSuccessHeader = new By.ByXPath(".//div[contains(text(),'Заказ оформлен')]");

    public OrderSuccessPageYandexSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void orderSuccessMessage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderSuccessHeader));
    }
}
