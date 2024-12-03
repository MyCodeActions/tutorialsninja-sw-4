package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class MyAccountPage extends Utility {

    By myAccountPageTile = By.xpath("//h2[normalize-space()='My Account']");

    public String getMyAccountPageTitle(){
        return getTextFromElement(myAccountPageTile);
    }
}