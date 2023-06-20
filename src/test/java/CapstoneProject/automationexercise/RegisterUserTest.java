package CapstoneProject.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Configuration.BaseConfiguration;

import org.openqa.selenium.support.ui.Select;

public class RegisterUserTest extends BaseConfiguration {

    @Test (threadPoolSize = 5)
    public void testAutomationFlow() {
        driver.get("https://automationexercise.com/");

        try {
            WebElement homeElement = driver.findElement(By.cssSelector("a[href='/']"));
            Assert.assertTrue(homeElement.isDisplayed(), "Home page is not visible");
            homeElement.click();
        } catch (NoSuchElementException e) {
            Assert.fail("Home element is not found on the page");
        }

        WebElement signupButton = driver.findElement(By.cssSelector("a[href='/login']"));
        signupButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'New User Signup!')]")).isDisplayed(),
                "'New User Signup!' is not visible");
    }


    @Test(priority = 3, threadPoolSize = 5)
    public void testAccountCreation() {
        // Enter name and email address
        WebElement nameInput = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        nameInput.sendKeys("Jagg12");
        WebElement emailInput = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        emailInput.sendKeys("Jage2@gmail.com");


        // Click 'Signup' button
        WebElement signupButton = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/button"));
        signupButton.click();

        // Fill account details

        WebElement titleInput = driver.findElement(By.cssSelector("input#id_gender1"));
        titleInput.click();

        WebElement passwordInput = driver.findElement(By.cssSelector("input[data-qa='password']"));
        passwordInput.sendKeys("Asdfghjkl");

        Select daySelect = new Select(driver.findElement(By.cssSelector("select[data-qa='days']")));
        daySelect.selectByValue("25");

        Select monthSelect = new Select(driver.findElement(By.cssSelector("select[data-qa='months']")));
        monthSelect.selectByValue("11");

        Select yearSelect = new Select(driver.findElement(By.cssSelector("select[data-qa='years']")));
        yearSelect.selectByValue("1998");

        // checkbox newsletter
        WebElement newsletterCheckbox = driver.findElement(By.cssSelector("input#newsletter"));
        newsletterCheckbox.click();


        WebElement offersCheckbox = driver.findElement(By.cssSelector("input#optin"));
        offersCheckbox.click();

        WebElement firstNameInput = driver.findElement(By.cssSelector("input[data-qa='first_name']"));
        firstNameInput.sendKeys("Jagath");

        // last name
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[data-qa='last_name']"));
        lastNameInput.sendKeys("Sai");

        // address
        WebElement addressInput = driver.findElement(By.cssSelector("input[data-qa='address']"));
        addressInput.sendKeys("asdfghj");

        // country
        Select countrySelect = new Select(driver.findElement(By.cssSelector("select[data-qa='country']")));
        countrySelect.selectByValue("India");

        // state
        WebElement stateInput = driver.findElement(By.cssSelector("input[data-qa='state']"));
        stateInput.sendKeys("AP");

        // city
        WebElement cityInput = driver.findElement(By.cssSelector("input[data-qa='city']"));
        cityInput.sendKeys("hyderabad");

        // zip code
        WebElement zipcodeInput = driver.findElement(By.cssSelector("input[data-qa='zipcode']"));
        zipcodeInput.sendKeys("500060");

        // mobile number
        WebElement mobileInput = driver.findElement(By.cssSelector("input[data-qa='mobile_number']"));
        mobileInput.sendKeys("9876543210");

        // Click button
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='form']/div/div/div/div/form/button"));
        submitButton.click();

        // Click button
        WebElement continueButton = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
        continueButton.click();

        // Click button
        WebElement deleteAccountElement = driver.findElement(By.cssSelector("a[href='/delete_account']"));
        deleteAccountElement.click();

        // Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeletedElement = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]"));
        Assert.assertTrue(accountDeletedElement.isDisplayed(), "Account Deleted! is not visible");

        // Click button
        WebElement continueButton1 = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
        continueButton1.click();

        driver.quit();
    }
}
