package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.Base;
import com.crm.qa.utilities.Utility;

public class Categories extends Base {

    static String price;
    WebDriver driver;
    By laptop = By.linkText("Laptops");
    By phone = By.linkText("Phones");
    By monitors = By.linkText("Monitors");
    By sonyLaptop = By.xpath(".//a[text()='Sony vaio i5']");
    By dellLaptop = By.xpath(".//a[text()='Dell i7 8gb']");
    By addToCart = By.xpath(".//a[text()='Add to cart']");
    By home = By.xpath(".//a[normalize-space(text())='Home']");
    By cart = By.xpath(".//a[normalize-space(text())='Cart']");
    By deleteDellLaptop = By
            .xpath(".//td[text()='Dell i7 8gb']/following-sibling::td/a");
    By placeOrder = By.xpath(".//button[text()='Place Order']");
    By amount = By.xpath(".//h3[@id='totalp']");

    public Categories(WebDriver driver) {
        this.driver = driver;
    }

    public void placeOrder() {

        try {

            driver.findElement(phone).click();
            driver.findElement(monitors).click();
            driver.findElement(laptop).click();
            Utility.waitForElementToBeClickable(driver, sonyLaptop, 25).click();
            Utility.waitForElementToBeClickable(driver, addToCart, 25).click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Utility.waitForElementToBeClickable(driver, home, 25).click();
            driver.findElement(laptop).click();
            Utility.waitForElementToBeClickable(driver, dellLaptop, 25).click();
            driver.findElement(addToCart).click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Utility.waitForElementToBeClickable(driver, cart, 25).click();
            Utility.waitForElementToBeClickable(driver, deleteDellLaptop, 25)
                    .click();
            Thread.sleep(2000);
            price = Utility.waitForElementToBeVisible(driver, amount, 25)
                    .getText();
            Thread.sleep(3000);
            driver.findElement(placeOrder).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
