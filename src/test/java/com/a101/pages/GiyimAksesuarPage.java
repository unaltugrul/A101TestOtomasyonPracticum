package com.a101.pages;

import com.a101.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiyimAksesuarPage extends BasePage{
    public GiyimAksesuarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@class='derin ']//a[@title='Kadın Giyim']")
    public WebElement kadinIcGiyim;
}
