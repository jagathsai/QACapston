package CapstoneProject.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Configuration.BaseConfiguration;

public class AddReviewTest extends BaseConfiguration {

    @Test
    public void testWriteReview() {
        driver.get("http://automationexercise.com");
        
        Dimension halfScreenSize = new Dimension(800, 600); // Adjust the dimensions as needed
        driver.manage().window().setSize(halfScreenSize);
        
        WebElement productsButton = driver.findElement(By.cssSelector("a[href='/products']"));
        productsButton.click();
        
        WebElement closeButton = null;
        try {
            closeButton = driver.findElement(By.cssSelector("CSS_SELECTOR_FOR_CLOSE_BUTTON"));
            closeButton.click();
            System.out.println("Popup closed successfully");
        } catch (NoSuchElementException e) {
            System.out.println("Popup already closed");
        }

        WebElement viewProductButton = driver.findElement(By.cssSelector("a[href='/product_details/1']"));
        viewProductButton.click();
    
        WebElement nameInput = driver.findElement(By.cssSelector("input#name"));
        nameInput.sendKeys("Jagathsai");

        WebElement emailInput = driver.findElement(By.cssSelector("input#email"));
        emailInput.sendKeys("jagathsai@gmail.com");

        WebElement reviewInput = driver.findElement(By.cssSelector("textarea#review"));
        reviewInput.sendKeys("expensive");

        WebElement submitButton = driver.findElement(By.cssSelector("button#button-review"));
        submitButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div.alert-success"));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals(successMessage.getText(), "Thank you for your review.");
    }
}
