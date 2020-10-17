package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.Categories;
import com.crm.qa.pages.PurchaseItem;

public class Purchase extends Base {

    final static Logger logger = Logger.getLogger(Purchase.class);

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
