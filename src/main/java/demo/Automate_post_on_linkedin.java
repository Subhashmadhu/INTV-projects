package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class Automate_post_on_linkedin {

    ChromeDriver driver;

    public Automate_post_on_linkedin() {
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
        element.sendKeys("user@gmail.com");
        // Enter the valid pass word in the box Using Locator "XPath"
        // //input[@id='session_password']|sendKeys(***)
        WebElement password = driver.findElement(By.xpath("//input[@id='session_password']"));
        password.sendKeys("user@1234 ");
        // click on the sign in button Using Locator "XPath"
        // //input[@id='session_password']|sendKeys(***)
        driver.findElement(By.xpath("//button[contains(@class, 'btn-md btn')]")).click();
        Thread.sleep(3000);
        // verify that login is succussful or not Using Locator "XPath" isDisplayed()
        WebElement login = driver.findElement(By.xpath("//li-icon[@type='app-linkedin-bug-color-icon']"));
        login.isDisplayed();
        System.out.println("linked in open succefully");
        // click on the photo uploaded button Using Locator "XPath"
        // //button[@aria-label='Add a photo']
        WebElement button = driver.findElement(By.xpath("//button[@aria-label='Add a photo']"));
        button.click();
        Thread.sleep(3000);
        // Send the Path of the File to the Element:
        // fileInput.sendKeys("path/to/your/photo.jpg");
        WebElement file_input = driver
                .findElement(By.xpath("//input[@id='image-sharing-detour-container__file-input']"));
        // filepath='C:\Users\HP\Pictures\Screenshots\Screenshot (160).png'
        file_input.sendKeys("C:\\Users\\HP\\Pictures\\Screenshots\\Screenshot (160).png");
        Thread.sleep(3000);
        // before 9th line select the image to share lable Using Locator "XPath"
        // //label[@class='artdeco-button artdeco-button--tertiary']
        driver.findElement(By.xpath("//button[contains(@class,'share-box-footer__primary-btn artdeco-button')]"))
                .click();
        // click on the done button Using Locator "XPath"
        // //button[contains(@class,'share-box-footer__primary-btn artdeco-button')]
    }
   
}
