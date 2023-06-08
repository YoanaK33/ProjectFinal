package com.selenium.course.tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import com.selenium.course.tests.base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItems extends TestUtil {


    @Test
    public void addItemToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartByProductName("backpack");

        Assert.assertEquals(productsPage.getNumbersInTheCart(), 1, "one added item in the cart");
    }

    @Test
    public void addSecondItemToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartByProductName("fleece-jacket");

        Assert.assertEquals(productsPage.getNumbersInTheCart(), 1, "second added item in the cart");
    }
}
