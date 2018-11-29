import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Selenium {

    @Test
    public void preventsEnteringNonexistentFlightNumberDuringOnlineCheckin() {
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        webDriver.get("https://www.rossiya-airlines.com/");
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String mainTitle = webDriver.getTitle();
        WebElement element = webDriver.findElement(By.name("number"));
        element.sendKeys("5555");
        element.submit();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String afterTitle = "Поиск пассажира";
        Assert.assertTrue(mainTitle.equals(afterTitle));
        webDriver.quit();
    }
}