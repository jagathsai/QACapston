package CapstoneProject.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Configuration.BaseConfiguration;

public class LoginUserTest extends BaseConfiguration {

    @Test
    public void testLoginAndDeleteAccount() {
        // Navigate to the URL
        driver.get("http://automationexercise.com");

        // Click on 'Signup / Login' button
        WebElement signupLoginButton = driver.findElement(By.cssSelector("a[href='/login']"));
        signupLoginButton.click();

        // Enter correct email address and password
        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.sendKeys("js@gmail.com");
        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys("Asdfghjkl");

        // Click 'Login' button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Click 'Delete Account' button
        //WebElement deleteAccountButton = driver.findElement(By.cssSelector("a[href='/delete_account']"));
       // deleteAccountButton.click();
        
        driver.quit();
    }
}
