package org.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException {
        System.out.println( "Hello World!" );

        Calculator calc = new Calculator();
        int sum = calc.sum(10,20);
        int diff = calc.sum(20,10);

        System.out.println("Sum is: " + sum);
        System.out.println("Diff is : " + diff);

        WebDriver driver = new ChromeDriver();

        //open URL
        driver.get("http://107.23.199.119:8080/addressbook-2.0/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        //locate contact button and click
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div[2]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("gwt-uid-5")).sendKeys("kushi");
        driver.findElement(By.id("gwt-uid-7")).sendKeys("Pavan");
        driver.findElement(By.id("gwt-uid-9")).sendKeys("9999999");
        driver.findElement(By.id("gwt-uid-11")).sendKeys("kushi@pavan.com");
        driver.findElement(By.id("gwt-uid-13")).sendKeys("06/01/2020,");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[3]/div/div[1]/div")).click();
        Thread.sleep(4000);

        /*driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement password = driver.findElement(By.name("my-password"));
        WebElement textarea = driver.findElement(By.name("my-textarea"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        Thread.sleep(2000);
        textBox.sendKeys("Selenium");
        password.sendKeys("password");
        textarea.sendKeys("Hello,how are you");
        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.id("message"));
        System.out.println(message.getText());*/

        //capture screenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("test-report.jpg");
        FileUtils.copyFile(srcFile,destFile);

        driver.quit();


    }

}
