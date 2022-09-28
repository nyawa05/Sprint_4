package service.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderFirstPageYandexSamokat {
    private final WebDriver driver;
    //Поле ввода Имени
    private final By nameField = new By.ByXPath(".//input[@placeholder = '* Имя']");
    //Поле ввода Фамилии
    private final By surnameField = new By.ByXPath(".//input[@placeholder = '* Фамилия']");
    //Поле ввода Адреса
    private final By addressField = new By.ByXPath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле ввода Станции метро
    private final By metroStationField = new By.ByXPath(".//input[@placeholder = '* Станция метро']");
    //Поле ввода Номера телефона
    private final By phoneField = new By.ByXPath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextButton = new By.ByXPath(".//div[@class = 'Order_NextButton__1_rCA']/button");

    public OrderFirstPageYandexSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField (String newName) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(newName);
    }
    public void setSurnameField (String newSurname) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(newSurname);
    }
    public void setAddressField (String newAddress) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(newAddress);
    }
    public void setMetroStationField (String newMetroStation) {
        driver.findElement(metroStationField).sendKeys(newMetroStation);
        String metroStationValue = ".//div[contains(text(),'%s')]";
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(new By.ByXPath(String.format(metroStationValue,newMetroStation)))).click();

    }
    public void setPhoneField (String newPhone) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(newPhone);
    }
    public void nextButtonClicked () {
             new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    public void enterAllFields (String newName, String newSurname, String newAddress, String newPhone, String newMetroStation) {
        setNameField(newName);
        setSurnameField(newSurname);
        setAddressField(newAddress);
        setPhoneField(newPhone);
        setMetroStationField(newMetroStation);
    }
}
