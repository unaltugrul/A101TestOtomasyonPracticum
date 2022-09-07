package com.a101.pages;

import com.a101.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DizaltiCorapPage extends BasePage{
    public DizaltiCorapPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//ul[@class='product-list-general']/li[1]//a)[1]")
    public WebElement ilkUrunLink;
}
