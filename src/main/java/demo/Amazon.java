package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
    WebDriver driver;

    public Amazon() {
        System.out.println("Constructor: Amazon");
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

    public void testcase() throws InterruptedException {
        driver.get("https://www.google.com");
        System.out.println("open google successfully");
        Thread.sleep(3000);
        WebElement searcharea = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        if (searcharea.isDisplayed()) {
            System.out.println("Search area is open successfully");
        } else {
            System.out.println("search area is not display");
        }
        searcharea.sendKeys("amazon");
        searcharea.sendKeys(Keys.RETURN);

        // driver.findElement(By.xpath ("(//input[@name='btnK'])[2]")).click();
        Thread.sleep(3000);
        //
        WebElement amazon = driver.findElement(By.xpath("(//span[text()='Amazon.in'])[1]"));
        if (amazon.isDisplayed()) {
            System.out.println("Amazon link is open successfully");
        } else {
            System.out.println("Amazon link is not display");
        }
    }
}
