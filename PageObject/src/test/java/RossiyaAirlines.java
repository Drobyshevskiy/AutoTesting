
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class RossiyaAirlines {
    WebDriver driver;

    @BeforeClass
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void preventsBookingWithoutAgreeingWithTermsOfService() {
        IndexPage index = new IndexPage(driver);
        index.setDepartureCity("МОСКВА");
        index.setArrivalCity("САНКТ-ПЕТЕРБУРГ");
        index.setOneWay();
        index.setTodayDepartureDate();
        index.submitForm();
        String expectError = "Подтвердите, если вы ознакомились и согласились с Правилами онлайн-бронирования.";
        assertEquals(expectError, index.confirmationError());

    }
}
