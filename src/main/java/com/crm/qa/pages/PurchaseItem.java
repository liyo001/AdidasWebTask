package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.crm.qa.base.Base;
import com.crm.qa.utilities.Utility;

public class PurchaseItem extends Base {

    WebDriver driver;
    By name = By.id("name");
    By country = By.id("country");
    By city = By.id("city");
    By card = By.id("card");
    By month = By.id("month");
    By year = By.id("year");
    By purchase = By.xpath(".//button[text()='Purchase']");
    By productDetails = By.xpath(".//p[@class='lead text-muted ']");
    By closeBtn = By.xpath(
            ".//h5[@id='orderModalLabel']/parent::div/button[@class='close']");
    By okBtn = By.xpath(".//button[text()='OK']");

    public PurchaseItem(WebDriver driver) {
        this.driver = driver;
    }

    public void purchaseNewItem(String Name, String Country, String City,
            String Card, String Month, String Year) {

        try {
            driver.findElement(name).sendKeys(Name);
            driver.findElement(country).sendKeys(Country);
            driver.findElement(city).sendKeys(City);
            driver.findElement(card).sendKeys(Card);
            driver.findElement(month).sendKeys(Month);
            Utility.sendKeyByJS(driver, year, Year);
            Utility.clickByJS(driver, purchase);
            Utility.clickByJS(driver, closeBtn);
            Utility.getscreenshot(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyProductDetails()

    {
        try {
            String count = driver
                    .findElement(
                            By.xpath("//p[contains(@class,'lead text-muted')]"))
                    .getAttribute("innerHTML");

            String[] prodDetails = count.split("<br>");

            String productID = prodDetails[0].substring(4);
            String actualPrice = prodDetails[1].substring(8, 11);

            System.out.println("Product ID- " + productID);
            System.out.println("Amount- " + productID);
            Assert.assertEquals(actualPrice, Categories.price);
            Utility.waitForElementToBeClickable(driver, okBtn, 15).click();
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
