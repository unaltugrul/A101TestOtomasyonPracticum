package com.a101.pages;

import com.a101.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PenKad50DenPanCorSiyah extends BasePage{
    public PenKad50DenPanCorSiyah(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='selected-variant-text']//span")
    public WebElement renk;

    @FindBy(xpath = "//a[@class='go-to-shop']")
    public WebElement sepetiGoruntule;


}
