package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_imdb_ratings {
    int counts = 0;
    int maxMoviesToPrint = 250;
    ChromeDriver driver;

    public Automate_imdb_ratings() {
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

    // Navegate to URl https://www.imdb.com/chart/top
    // get the highest rated movie on IMDb Using Locator "XPath"
    // (//h3[@class='ipc-title__text'])[2]
    // get the text of highest rated movie getText()
    // make a list for all movies list<webElement>list Using Locator "XPath"
    // getText()
    // print the all including movies in the list size()
    // Create a class for Selecting drop down Using Locator "ID" Select se = new
    // Select(driver.findElement(By.id("sort-by-selector")));
    // select the text se.release date
    // locate the oldest movie in the list Using Locator "XPath"
    // (//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[250]/div
    // get the text for the movie getText()
    // locate the recent realise movie in the list Using Locator "XPath"
    // (//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[1]/div
    // get movie name getText()
    // locate the most user rating movie in the list Using Locator "XPath"
    // (//h3[@class='ipc-title__text'])[2]
    // get the title of a movie getText()
    public void imbdratng() throws InterruptedException {
        driver.get("https://www.imdb.com/chart/top");
        WebElement highratingmovie = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
        String movieName = highratingmovie.getText();
        System.out.println("Highest Rating movie:" + movieName);
        List<WebElement> listofmovies = driver.findElements(
                By.xpath("//li[@class='ipc-metadata-list-summary-item sc-bca49391-0 eypSaE cli-parent']"));
        int moviesname = listofmovies.size();
        System.out.println("Count of all movies:" + moviesname);
        List<WebElement> movies = driver.findElements(By.xpath("(//a[@class='ipc-title-link-wrapper']//h3)"));
        for (WebElement movie : movies) {
            String abc = movie.getText();
            if (counts < maxMoviesToPrint) {
                System.out.println("Movie name: " + abc);
                counts++;
            } else {
                break;
            }
        }
        Thread.sleep(2000);
        Select se = new Select(driver.findElement(By.xpath("//select[@id='sort-by-selector']")));
        se.selectByVisibleText("Release date");
        // driver.findElement(By.xpath("//select[@id='sort-by-selector']")).click();
        // driver.findElement(By.xpath("//option[text()='Release date']")).click();
        Thread.sleep(2000);
        WebElement oldmovie = driver
                .findElement(By.xpath("(//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[250]/div"));
        String oldestmovie = oldmovie.getText();
        System.out.println("Oldest movie in the list is:" + oldestmovie);
        WebElement recentmovie = driver
                .findElement(By.xpath(" (//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[1]/div"));
        String old = recentmovie.getText();
        System.out.println("recently releasemovie in the list is:" + old);
        String userratingMovie = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]")).getText();
        System.out.println("Most usr rating movies is:" + userratingMovie);
    }

}
