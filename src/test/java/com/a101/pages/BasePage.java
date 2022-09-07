package com.a101.pages;

import com.a101.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //giyim aksesuar modul link
    @FindBy(xpath = "//ul[@class='desktop-menu']//a[@title='GİYİM & AKSESUAR']")
    public WebElement giyimAksesuarModul;

    //diz altı çorap alt kategori link
    @FindBy(xpath = "//a[@title='Dizaltı Çorap']")
    public WebElement dizaltiCorap;

    //sepete ekle butonu
    @FindBy(xpath = "//button[@class='add-to-basket button green block with-icon js-add-basket']")
    public WebElement sepeteEkleButon;

}
