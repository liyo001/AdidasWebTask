package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adidas.qa.base.Base;
import com.adidas.qa.pages.Categories;
import com.adidas.qa.pages.PurchaseItem;

public class Purchase extends Base {
    Categories cat;
    PurchaseItem pur;

    public Purchase() {
        super();
    }

    @BeforeMethod

    public void setup() {
        initialization();
        cat = new Categories(driver);
        pur = new PurchaseItem(driver);
    }

    @Test
    public void placeOrder() {

        cat.placeOrder();
        pur.purchaseNewItem("Ram", "India", "Deoria", "1234-1234-1234-1234",
                "December", "2020");
        pur.verifyProductDetails();

    }
}
