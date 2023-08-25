package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bookmyshow {
    ChromeDriver driver;

    public Bookmyshow() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void bookmyshow() {
        // "Navigate to book my show URL
        driver.get("www.Amazon.com");
        // List all hyperlink in bookmyshow that can store in List<WebElement>list Using
        // Locator "Tag Name" a
        List<WebElement> imageUrl = driver.findElements(By.tagName("a"));
        // find the size of url
        int count = imageUrl.size();
        System.out.println("count of url is:" + count);

    }
}