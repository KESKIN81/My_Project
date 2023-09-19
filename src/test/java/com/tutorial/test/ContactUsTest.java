package com.tutorial.test;

import com.tutorial.utilities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTest extends BaseTest {

    @Test

    public void contactUs() throws InterruptedException {

        WebElement pageLoad = driver.findElement(By.linkText("Qafox.com"));
        String expectedTitle = "Qafox.com";
        String actualTitle = pageLoad.getText();
        Assert.assertEquals(actualTitle,expectedTitle,"Title esit degildir");


        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        Thread.sleep(2000);
        contactUs.click();


        WebElement yourName = driver.findElement(By.id("input-name"));
        WebElement emailAddress = driver.findElement(By.id("input-email"));
        WebElement enquiry = driver.findElement(By.id("input-enquiry"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));

        yourName.sendKeys("Mucahid Keskin");
        emailAddress.sendKeys("mucahidkeskin81@gmail.com");
        enquiry.sendKeys("Urunlerinizle ilgileniyorum benimle baglantiya gecermisiniz");
        Thread.sleep(3000);
        submitButton.click();

        WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        Assert.assertTrue(continueButton.isEnabled(),"Continue button gorulemedi");
        Thread.sleep(2000);
        continueButton.click();



    }

    @Test
    public void invalidEmail() throws InterruptedException {


        WebElement pageLoad = driver.findElement(By.linkText("Qafox.com"));
        String expectedTitle = "Qafox.com";
        String actualTitle = pageLoad.getText();
        Assert.assertEquals(actualTitle,expectedTitle,"Title esit degildir");


        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        Thread.sleep(2000);
        contactUs.click();


        WebElement yourName = driver.findElement(By.id("input-name"));
        WebElement emailAddress = driver.findElement(By.id("input-email"));
        yourName.sendKeys("Mucahid Keskin");
        emailAddress.sendKeys("mucahidkeskin81@gmail.com");
        Thread.sleep(2000);
        emailAddress.clear();
        emailAddress.sendKeys("mucahidkeskin81gmail.com");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-danger']"));
        String expectedErrorMessage = "E-Mail Address does not appear to be valid!";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Mesaj eslesmiyor");
        Thread.sleep(3000);
    }

    @Test
    public void negativeEnquiry() throws InterruptedException {
        WebElement pageLoad = driver.findElement(By.linkText("Qafox.com"));
        String expectedTitle = "Qafox.com";
        String actualTitle = pageLoad.getText();
        Assert.assertEquals(actualTitle,expectedTitle,"Title esit degildir");


        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        Thread.sleep(2000);
        contactUs.click();


        WebElement yourName = driver.findElement(By.id("input-name"));
        WebElement emailAddress = driver.findElement(By.id("input-email"));
        WebElement enquiry = driver.findElement(By.id("input-enquiry"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));

        yourName.sendKeys("Mucahid Keskin");
        emailAddress.sendKeys("mucahidkeskin81@gmail.com");
        enquiry.sendKeys("Urunlerinizle ilgileniyorum benimle baglantiya gecermisiniz");
        Thread.sleep(2000);
        enquiry.clear();
        enquiry.sendKeys("Thank you");
        Thread.sleep(2000);
        submitButton.click();
        WebElement enquiryMessage = driver.findElement(By.cssSelector("div.text-danger"));
        String expectedMessage = "Enquiry must be between 10 and 3000 characters!";
        String actualMessage = enquiryMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Mesaj eslesmiyor");
        Thread.sleep(2000);

    }
}