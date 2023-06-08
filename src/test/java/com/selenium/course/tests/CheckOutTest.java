package com.selenium.course.tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import com.selenium.course.tests.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends TestUtil {
    @Test
    public void checkOutItems(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartByProductName("onesie");

        WebElement shoppingCartBtn = driver.findElement(By.className("shopping_cart_link"));
        shoppingCartBtn.click();

        WebElement checkOutBtn = driver.findElement(By.id("checkout"));
        checkOutBtn.click();

        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys("Yoana");

        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys("Kancheva");

        WebElement postalCodeInput = driver.findElement(By.id("postal-code"));
        postalCodeInput.sendKeys("1000");

        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();

        WebElement finishBtn = driver.findElement(By.id("finish"));
        finishBtn.click();

        WebElement checkOutCompleteLogo = driver.findElement(By.className("complete-header"));
        Assert.assertTrue(checkOutCompleteLogo.isDisplayed());
    }

}

