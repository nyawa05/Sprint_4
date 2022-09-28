package service.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSecondPageYandexSamokat {
    private final WebDriver driver;
    //Поле ввода Даты доставки
    private final By dateToDeliverField = new By.ByXPath(".//input[@placeholder = '* Когда привезти самокат']");
    //Поле ввода Периода пользования
    private final By rentPeriodField = new By.ByXPath(".//span[@class = 'Dropdown-arrow']");
    //Кнопка "Заказать"
    private final By orderButton = new By.ByXPath(".//div[@class = 'Order_Buttons__1xGrp']/button[contains(text(),'Заказать')]");

    public OrderSecondPageYandexSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void setDateToDeliverField(String newDate) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(dateToDeliverField));
        driver.findElement(dateToDeliverField).sendKeys(newDate);
    }

    public void rentPeriodFieldClicked () {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(rentPeriodField)).click();
    }
    public void setRentPeriodField (int newPeriod) {
        String period = null;
        switch (newPeriod) {
            case 1:
                period = "сутки";
                break;
            case 2:
                period = "двое суток";
                break;
            case 3:
                period = "трое суток";
                break;
            case 4:
                period = "четверо суток";
                break;
            case 5:
                period = "пятеро суток";
                break;
            case 6:
                period = "шестеро суток";
                break;
            case 7:
                period = "семеро суток";
                break;
        }
        String rentPeriod = ".//div[@role = 'option' and contains(text(),'%s')]";
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(new By.ByXPath(String.format(rentPeriod,period)))).click();
    }

    public void orderButtonClicked() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderButton)).click();
    }

    public void enterNecessaryFields(String newDate, int newPeriod) {
        setDateToDeliverField(newDate);
        rentPeriodFieldClicked();
        setRentPeriodField(newPeriod);
    }
}
