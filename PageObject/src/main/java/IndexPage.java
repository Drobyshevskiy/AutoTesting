
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='Откуда']")
    private WebElement departureCity;

    @FindBy(xpath = "//input[@placeholder='Куда']")
    private WebElement arrivalCity;

    @FindBy(xpath = "//label[contains(@class, 'form-radio is-white') and contains(.//span, 'В одну сторону')]")
    private WebElement oneWay;

    @FindBy(xpath = "//button[contains(@class, 'ui-state-highlight')]")
    private WebElement todayDepartureDate;

    @FindBy(id = "race-online")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='lpc-error']/p")
    private WebElement errorconfirmation;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.rossiya-airlines.com");
        PageFactory.initElements(driver, this);
    }

    public void setDepartureCity(String departure) {
        departureCity.sendKeys(departure);
    }

    public void setArrivalCity(String arrival) {
        arrivalCity.sendKeys(arrival);
    }

    public void setOneWay() {
        oneWay.click();
    }

    public void setTodayDepartureDate() {
        ((JavascriptExecutor) driver).executeScript("return document.getElementById('flight-start').click()");
        todayDepartureDate.click();
    }

    public void submitForm() {
        submitButton.click();
    }

    public String confirmationError(){
        return checkVisibility(errorconfirmation).getText();

    }
    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
