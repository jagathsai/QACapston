package CapstoneProject.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Configuration.BaseConfiguration;

public class incorrectEmailPasswordTest extends BaseConfiguration {

    @Test
    public void testLoginAndVerifyErrorMessage() {
        driver.get("http://automationexercise.com");

        WebElement signupLoginButton = driver.findElement(By.cssSelector("a[href='/login']"));
        signupLoginButton.click();

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.sendKeys("h@gmail.com");
        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys("Asdfghjkl");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("p[style='color: red;']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        Assert.assertEquals(errorMessage.getText(), "Your email or password is incorrect!");

        driver.quit();
    }
}

