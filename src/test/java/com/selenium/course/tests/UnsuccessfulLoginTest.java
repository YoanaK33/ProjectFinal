package com.selenium.course.tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.selenium.course.tests.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class UnsuccessfulLoginTest extends TestUtil {
    @BeforeMethod
    private void setUpNewSession() {
    }
    @AfterMethod
    public void tearDownSession() {driver.quit();}


    @DataProvider (name = "readUsersFromCsvFile")
    public Object [][] readWrongUsersFromCsv() throws IOException, CsvException{
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/usersList.csv"))){
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }
    
    @Test (dataProvider = "readUsersFromCsvFile" )
    public void LoginWithWrongUser(String userName, String password){

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("userName");
        userNameInput.clear();

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("password");
        passwordInput.clear();

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();

        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(wrongUserBtn.isDisplayed());
    }
}


