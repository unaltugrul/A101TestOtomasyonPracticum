package com.a101.pages;

import com.a101.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SepetPage extends BasePage{
    public SepetPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='basket-list']//a[@class='title']")
    public WebElement eklenenUrun;

    @FindBy(xpath = "//div[@class='col-sm-3']//a[@title='Sepeti Onayla']")
    public WebElement sepetiOnaylaButonu;
}
