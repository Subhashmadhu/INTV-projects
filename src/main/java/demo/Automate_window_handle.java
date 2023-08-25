package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
// import ru.yandex.qatools.ashot.AShot;
// import ru.yandex.qatools.ashot.Screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_window_handle {
    ChromeDriver driver;

    public Automate_window_handle() {
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

    public void windowshandle() throws InterruptedException {
        driver.get(" https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        String parentwindow = driver.getWindowHandle();
        driver.switchTo().window(parentwindow);
        System.out.println("first poyaa");
        driver.switchTo().frame("iframeResult");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Set<String> windowhandles = driver.getWindowHandles();
        for (String windows : windowhandles) {
            System.out.println("windows all " + windows);
            if (!windows.equals(parentwindow)) {
                // driver.switchTo().window(windows);
                System.out.println("child window" + windows);
                System.out.println("URL of the page:" + driver.getCurrentUrl());
                System.out.println("Title of the page:" + driver.getTitle());
                Thread.sleep(3000);
                File sourse = driver.getScreenshotAs(OutputType.FILE);
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                File savefile = new File("Screenshot " + timeStamp + ".png");
                try {
                    FileUtils.copyFile(sourse, savefile);
                } catch (IOException e) {
                    System.out.println("ScreenShot is not recognize");
                    e.printStackTrace();
                }

                
            }
            
        }

    }
}
