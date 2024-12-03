package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DeskTopsPage extends Utility {



    By desktopTitle = By.xpath("//h2[normalize-space()='Desktops']");
    By listOfProduct = By.xpath("//h4/a");
    By productSorting = By.id("input-sort");

    public String getDesktopPageTitle() {
        return getTextFromElement(desktopTitle);
    }

    public List<WebElement> getListsOfProduct(){
        return getWebElements(listOfProduct);
    }


    public void selectSortByZToA(String option){
        selectByVisibleTextFromDropDown(productSorting, option);
    }

    public void clickOnYourSelectedProduct(String productName){
        clickOnElement(By.linkText(productName));
    }
}


//    By desktopsTab = By.linkText("Desktops");
//    By showAllDesktops = By.linkText("Show AllDesktops");
//    By productList = By.xpath("//h4/a");
//    By sortByDropdown = By.id("input-sort");
//
//    By currencyDropdown = By.xpath("//span[contains(text(),'Currency')]");
//    By currencyOptions = By.xpath("//ul[@class='dropdown-menu']/li");
//    By hpLP3065Link = By.xpath("//a[contains(text(),'HP LP3065')]");
//    By productHeader = By.xpath("//h1[contains(text(),'HP LP3065')]");
//    By calendarButton = By.xpath("//div[@class='input-group date']//button");
//    By monthYearPicker = By.xpath("//div[@class='datepicker']/div[1]//th[@class='picker-switch']");
//    By nextMonthButton = By.xpath("//div[@class='datepicker']/div[1]//th[@class='next']");
//    By daysInCalendar = By.xpath("//div[@class='datepicker']/div[1]//tbody/tr/td[@class='day']");
//    By addToCartButton = By.xpath("//button[@id='button-cart']");
//    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
//    By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
//    By shoppingCartHeader = By.xpath("//div[@id='content']//h1");
//    By cartProductName = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a");
//    By cartDeliveryDate = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/small[1]");
//    By cartModel = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[3]");
//    By cartTotal = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]");
//
//
//
//    public void verifyProductArrangeInAlphabeticalOrder() {
//        // 1. Mouse hover and click on Desktops
//        mouseHoverToElementAndClick(desktopsTab);
//
//        // 2. Click on "Show All Desktops"
//        clickOnElement(showAllDesktops);
//
//        // 3. Get all product names and store them in an ArrayList
//        List<WebElement> products = getListOfElements(productList);
//        ArrayList<String> originalProductNames = new ArrayList<>();
//        for (WebElement product : products) {
//            originalProductNames.add(product.getText());
//        }
//        System.out.println("Original Product Names: " + originalProductNames);
//
//        // 4. Sort the list in reverse order
//        Collections.reverse(originalProductNames);
//        System.out.println("Reversed Product Names: " + originalProductNames);
//
//        // 5. Select "Name: Z to A" from the dropdown
//        //selectByVisibleTextFromDropDown(sortByDropdown, "Name (Z - A)");
//
//        // 6. Get all products after sorting and store in a new list
//        products = getListOfElements(productList);
//        ArrayList<String> sortedProductNames = new ArrayList<>();
//        for (WebElement product : products) {
//            sortedProductNames.add(product.getText());
//        }
//        System.out.println("Sorted Product Names: " + sortedProductNames);
//
//        // 7. Assert that the two lists match
//        //Assert.assertEquals(originalProductNames, sortedProductNames, "Product not sorted into Z to A order");
//    }
//
//
//    public void verifyProductAddedToShoppingCartSuccessfully() {
//        // 1. Change currency to "£ Pound Sterling"
//        clickOnElement(currencyDropdown);
//        selectByContainsTextFromListOfElements(currencyOptions, "£Pound Sterling");
//
//        // 2. Mouse hover on Desktops and click "Show All Desktops"
//        mouseHoverToElementAndClick(desktopsTab);
//        clickOnElement(showAllDesktops);
//
//        // 3. Sort products by "Name: A to Z"
//        selectByVisibleTextFromDropDown(sortByDropdown, "Name (A - Z)");
//
//        // 4. Click on "HP LP3065"
//        clickOnElement(hpLP3065Link);
//
//        // 5. Verify the product name "HP LP3065"
//
//        Assert.assertEquals(getTextFromElement(productHeader), "HP LP3065", "HP LP3065 Product not displayed");
//
//        // 6. Select delivery date "2025-11-30"
//        selectDateFromDatePicker(calendarButton, monthYearPicker, nextMonthButton, daysInCalendar, "2025", "November", "30");
//
//        // 7. Click on "Add to Cart"
//        clickOnElement(addToCartButton);
//
//        // 8. Verify success message
//        Assert.assertTrue(getTextFromElement(successMessage).contains("Success: You have added HP LP3065 to your shopping cart!"),
//                "Product not added to cart");
//
//        // 9. Click on "shopping cart" in the success message
//        clickOnElement(shoppingCartLink);
//
//        // 10. Verify the shopping cart page
//        Assert.assertTrue(getTextFromElement(shoppingCartHeader).contains("Shopping Cart"), "Shopping Cart page not displayed");
//
//        // 11. Verify product name in the cart
//        Assert.assertEquals(getTextFromElement(cartProductName), "HP LP3065", "Product name in cart does not match");
//
//        // 12. Verify delivery date in the cart
//        Assert.assertTrue(getTextFromElement(cartDeliveryDate).contains("2025-11-30"), "Delivery date does not match");
//
//        // 13. Verify product model
//        Assert.assertEquals(getTextFromElement(cartModel), "Product 21", "Product model does not match");
//
//        // 14. Verify total price
//        Assert.assertEquals(getTextFromElement(cartTotal), "£74.73", "Total price does not match");
//    }
//}
