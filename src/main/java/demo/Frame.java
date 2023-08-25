package demo;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class Frame{
    ChromeDriver driver;
    public Frame()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public void framehandling(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        // Switch parent frame
        driver.switchTo().frame("frame-top");
    
        // Switch to the left frame
        driver.switchTo().frame("frame-left");
    
        // Get the text from the left  frame
        WebElement LeftFrame = driver.findElement(By.tagName("body"));
        String LeftFrameText = LeftFrame.getText();
        System.out.println("The text of frame left: " + LeftFrameText);
    
        // Switch back to the default content
        driver.switchTo().parentFrame();
    
        // Switch to the middle  frame
        driver.switchTo().frame("frame-middle");
    
        // Get the text from the middle  frame
        WebElement MiddleFrame = driver.findElement(By.tagName("body"));
        String MiddleFrameText = MiddleFrame.getText();
        System.out.println("The text of frame middle: " + MiddleFrameText);
    
        // Switch back to the parent frame
        driver.switchTo().parentFrame();
    
        // Switch to the bottom frame
        driver.switchTo().frame("frame-right");
    
        // Get the text from the bottom frame
        WebElement RightFrame = driver.findElement(By.tagName("body"));
        String RightFrameText = RightFrame.getText();
        System.out.println("The text of frame right: " + RightFrameText);
    
        // Switch back to the default content
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame("frame-bottom");
    
        // Get the text from the bottom frame
        WebElement bottomFrame = driver.findElement(By.tagName("body"));
        String bottomFrameText = bottomFrame.getText();
        System.out.println("The text of frame bottom: " + bottomFrameText);
        driver.switchTo().defaultContent();
}
}
     