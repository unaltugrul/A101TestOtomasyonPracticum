package com.a101.pages;

import com.a101.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PenKad50DenPanCorSiyahPage extends BasePage{
    public PenKad50DenPanCorSiyahPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='selected-variant-text']//span")
    public WebElement renk;

    @FindBy(linkText = "Sepeti Görüntüle")
    public WebElement sepetiGoruntule;


}
