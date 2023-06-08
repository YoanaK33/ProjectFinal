package com.selenium.course.tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import com.selenium.course.tests.base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemsTogether extends TestUtil {

        @Test
        public void addItemsTogether() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

            productsPage.addToCartByProductName("backpack");
            productsPage.addToCartByProductName("fleece-jacket");

            Assert.assertEquals(productsPage.getNumbersInTheCart(), 2, "Two added items" );
        }
    }


