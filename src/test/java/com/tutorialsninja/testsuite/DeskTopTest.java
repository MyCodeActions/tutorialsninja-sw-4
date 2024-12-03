package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DeskTopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductDetailPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class DeskTopTest extends BaseTest {

    HomePage homePage = new HomePage();
    DeskTopsPage desktopsPage = new DeskTopsPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        // Mouse hover on the Desktops Tab. and click
        homePage.mouseHoverOnDesktop();

        // Click on “Show AllDesktops
        homePage.clickOnMenuOption("Show AllDesktops");

        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListsOfProduct()) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        // Select Sort By position "Name: Z to A
        desktopsPage.selectSortByZToA("Name (Z - A)");

        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListsOfProduct()) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        // Verify the Product will be arranged in Descending order.
        Assert.assertEquals(afterSortByZToAProductsName, originalProductsName,
                "Product not sorted into Z to A order");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // Mouse hover on the Currency Dropdown and click
        homePage.mouseHoverOnCurrencyAndClickOn();

        // Mouse hover on the £Pound Sterling and click
        homePage.selectCurrencyAsAPound("£Pound Sterling");

        // Mouse hover on the Desktops Tab.
        homePage.mouseHoverOnDesktop();

        // Click on the “Show AllDesktops
        homePage.clickOnMenuOption("Show AllDesktops");

        // Select the Sort By position "Name: A to Z
        desktopsPage.selectSortByZToA("Name (A - Z)");

        // Select product “HP LP3065”
        desktopsPage.clickOnYourSelectedProduct("HP LP3065");

        // Verify the Text "HP LP3065"
        Assert.assertEquals(productDetailPage.getPageTitle(), "HP LP3065",
                "Product not display");

        // Select Delivery Date "2024-11-27
        productDetailPage.selectDeliveryDate("2024", "November", "27");

        Thread.sleep(1000);

        // .Enter Qty "1” using Select class.
        productDetailPage.enterQuantity("1");

        Thread.sleep(1000);
        // Click on the “Add to Cart” button
        productDetailPage.clickOnAddToCartButton();


        Thread.sleep(1000);
        // Verify the Message “Success: You have added HP LP3065 to your shopping cart!
        Assert.assertTrue(productDetailPage.getProductAddToCartSuccessMessage()
                        .contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");

        Thread.sleep(2000);
        // Click on the link “shopping cart” displayed in a success message
        productDetailPage.clickOnShoppingCartLink();

        Thread.sleep(2000);
        // Verify the text "Shopping Cart
        Assert.assertTrue(shoppingCartPage.getShoppingCartPageTitle().contains("Shopping Cart"));

        // Verify the Product name "HP LP3065
        Assert.assertEquals(shoppingCartPage.getProductName(), "HP LP3065",
                "Product name not matched");

        // Verify the Delivery Date "2024-11-27"
        Assert.assertTrue(shoppingCartPage.getDeliveryDate().contains("2024-11-27"),
                "Delivery date not matched");

        // Verify the Model "Product21
        Assert.assertEquals(shoppingCartPage.getProductModel(), "Product 21",
                "Model not matched");

        // Verify the Todat "£74.73
        Assert.assertEquals(shoppingCartPage.getProductTotalPrise(), "£74.73",
                "Total not matched");
    }
}