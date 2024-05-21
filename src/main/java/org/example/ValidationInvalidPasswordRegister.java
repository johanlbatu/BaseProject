package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationInvalidPasswordRegister {
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
        jse.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(2000);
        WebElement textboxFirstName =driver.findElement(By.xpath("//input[@id='firstname']"));
        WebElement textboxLastName =driver.findElement(By.xpath("//input[@id='lastname']"));
        WebElement textboxUserName =driver.findElement(By.xpath("//input[@id='userName']"));
        WebElement textboxPassword =driver.findElement(By.xpath("//input[@id='password']"));
        WebElement btnRegister = driver.findElement(By.xpath("//button[@id='register']"));
        Thread.sleep(5000);
        WebElement checkboxCAPTCHA = driver.findElement(By.xpath("//span[@id='recaptcha-anchor']//div[@class='recaptcha-checkbox-border']"));
        textboxFirstName.sendKeys("Johan");
        textboxLastName.sendKeys("QA");
        textboxUserName.sendKeys("qatest");
        textboxPassword.sendKeys("Qwerty123");
        btnRegister.click();
        checkboxCAPTCHA.click();
        WebElement textWarning = driver.findElement(By.xpath("//p[@id='name']"));
        String actualMessage = textWarning.getText();
        String expectedMessage = "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.";
        Assert.assertEquals(expectedMessage,actualMessage);
        Thread.sleep(2000);
        driver. close();

    }

}