package org.example;

import org.common.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserVisitAndSearchBooksPages {
    private WebDriver driver;


//    @FindBy(xpath = "//*[@id=\"userName\"]")
//    public WebElement textboxUserName;
//    @FindBy(xpath = "//*[@id=\"password\"]")
//    public WebElement textboxPassword;
//    @FindBy(xpath = "//*[@id=\"login\"]")
//    public WebElement btnPassword;

    @Test
    public  void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/ChromeDriver/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Explicit wait

        driver.get("https://demoqa.com/books");
        Thread.sleep(2000);
        WebElement textSearch =driver.findElement(By.xpath("//input[@id='searchBox']"));
        textSearch.click();
        textSearch.sendKeys("Git Pocket Guide");
        WebElement books =driver.findElement(By.xpath("//span[@id='see-book-Git Pocket Guide']"));
        Assert.assertEquals(books.isDisplayed(),true);
        books.click();
        driver.getCurrentUrl();
        Thread.sleep(5000);
        driver. close();








    }
}