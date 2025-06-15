package Academy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserTest {

    @Test
    public void getData() {
        System.out.println("Running Selenium Test...");

        // ✅ Automatically sets up chromedriver version
        WebDriverManager.chromedriver().setup();

        // ✅ Enable headless mode for Azure DevOps agents
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // or "--headless"
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.azurewebsites.net/webapp/");
        String text = driver.findElement(By.cssSelector("h1")).getText();
        System.out.println("Header Text: " + text);

        Assert.assertTrue(text.equalsIgnoreCase("RahulShettyAcademy.com Learning"));

        driver.quit();
    }
}
