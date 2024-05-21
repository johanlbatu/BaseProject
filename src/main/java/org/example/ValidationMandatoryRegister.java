package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationMandatoryRegister {
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

        driver.get("https://demoqa.com/register");
        Thread.sleep(2000);
        WebElement btnRegister = driver.findElement(By.xpath("//button[@id='register']"));
        jse.executeScript("window.scrollBy(0,450)", "");
        btnRegister.click();
        Thread.sleep(2000);
        WebElement textboxFirstName =driver.findElement(By.xpath("//input[@class='mr-sm-2 is-invalid form-control'][@id='firstname']"));
        WebElement textboxLastName =driver.findElement(By.xpath("//input[@class='mr-sm-2 is-invalid form-control'][@id='lastname']"));
        WebElement textboxUserName =driver.findElement(By.xpath("//input[@class='mr-sm-2 is-invalid form-control'][@id='userName']"));
        WebElement textboxPassword =driver.findElement(By.xpath("//input[@class='mr-sm-2 is-invalid form-control'][@id='password']"));
        Assert.assertEquals(textboxFirstName.isDisplayed(),true);
        Assert.assertEquals(textboxLastName.isDisplayed(),true);
        Assert.assertEquals(textboxUserName.isDisplayed(),true);
        Assert.assertEquals(textboxPassword.isDisplayed(),true);
        Thread.sleep(5000);
        driver. close();

    }

}