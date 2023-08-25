package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_view_on_linkedin {
    ChromeDriver driver;

    public Automate_view_on_linkedin() {
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

    public void postimage() throws InterruptedException {
        // navigate to url www.linkedin.com

        driver.get(" https://in.linkedin.com/ ");
        // Enter the valid Email or phone number in the box Using Locator "XPath"
        // //input[@id='session_key']| send Keys(*******)
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//input[@id='session_key']"));
        element.sendKeys("user@123.gmail.com");
        // Enter the valid pass word in the box Using Locator "XPath"
        // //input[@id='session_password']|sendKeys(***)
        WebElement password = driver.findElement(By.xpath("//input[@id='session_password']"));
        password.sendKeys("User@123");
        // click on the sign in button Using Locator "XPath"
        // //input[@id='session_password']|sendKeys(***)
        driver.findElement(By.xpath("//button[contains(@class, 'btn-md btn')]")).click();
        Thread.sleep(3000);
        // verify that login is succussful or not Using Locator "XPath" isDisplayed()
        WebElement login = driver.findElement(By.xpath("//li-icon[@type='app-linkedin-bug-color-icon']"));
        login.isDisplayed();
        System.out.println("linked in open successfully");
    }
}