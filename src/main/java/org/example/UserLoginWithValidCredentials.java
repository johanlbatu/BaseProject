package org.example;

import org.common.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginWithValidCredentials {
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
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Explicit wait

        driver.get("https://demoqa.com/login");
        Thread.sleep(5000);
        jse.executeScript("window.scrollBy(0,250)", "");
        WebElement textboxUserName =driver.findElement(By.xpath("//input[@id='userName']"));
        WebElement textboxPassword =driver.findElement(By.xpath("//input[@id='password']"));
        WebElement btnPassword = driver.findElement(By.xpath("//button[@id='login']"));
        textboxUserName.click();
        textboxUserName.sendKeys("batubatu");
        Thread.sleep(2000);
        textboxPassword.click();
        textboxPassword.sendKeys("Qwerty123!");
        Thread.sleep(2000);
        btnPassword.click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/profile");
        MyLogger.info("We are on profile pages");
        Thread.sleep(5000);
        driver. close();








    }
}