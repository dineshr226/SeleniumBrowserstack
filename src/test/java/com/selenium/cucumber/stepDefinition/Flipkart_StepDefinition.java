package com.selenium.cucumber.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Flipkart_StepDefinition {
    WebDriver driver;

    @When("user opens flipkart site")
    public void whenUserEntersSearchString() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(js.executeScript("return document.readyState").toString().equals("complete")){
            //Page is loaded
            System.out.println("Page loaded");
        } else {
            driver.navigate().refresh();
        }
        String title = driver.getTitle();
        System.out.println("Page Title" + title);
        Thread.sleep(2000);
    }

    @Then("Search result is displayed for {string}")
    public void thenVerifySearchResult(String str) throws InterruptedException {
        System.out.println("Then - Verify Search result - " +str);
        WebElement webElement = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
        webElement.click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input._3704LK")).sendKeys(str);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.L0Z3Pu")).click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Mobiles")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img._3U-Vxu")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
