package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_image_urls {
    ChromeDriver driver;

    public Automate_image_urls() {
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

    public void imgurl() {
        // "Navigate to book my show URL
        driver.get("//https://in.bookmyshow.com/explore/home/chennai");
        // "Navigate to book my show URL
        // https://in.bookmyshow.com/explore/home/chennai "
        // Find all the image URl for recommanded movies and store in to
        // List<webelement>list Using Locator "XPath" //div[@class='sc-lnhrs7-4
        // dDgeSF']//a
        // print all webelements in a list list. |getAttribute()
        // Scroll to premier list list. |getAttribute()
        // Find the Name of the 2nd item in the “Premiere” list and store in to
        // List<webelement> Using Locator "XPath" (//div[@class='sc-7o7nez-0
        // iHsoLV'])[2]
        // Find the Language of the 2nd item in the “Premiere” list and store in to
        // List<webelement> Using Locator "XPath" (//div[@class='sc-7o7nez-0
        // iHsoLV'])[2]
        // print the Name and Language in the llist list. |getAttribute()
        // close Browser close()
        List<WebElement> recommandedImageurl = driver.findElements(By.xpath("//div[@class='sc-lnhrs7-4 dDgeSF']//a"));
        int imagecount = recommandedImageurl.size();
        System.out.println("count of imageurl for recomanded:" + imagecount);
        Actions as = new Actions(driver);
        WebElement move = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 iHsoLV'])[2]"));
        as.moveToElement(move).perform();
        WebElement name = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 iHsoLV'])[2]"));
        String Name = name.getText();
        System.out.println("nameofsecondElement" + Name);
        WebElement Language = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 iHsoLV'])[2]"));
        String movie = Language.getText();
        System.out.println("nameofsecondElement Language" + movie);
    }
}
