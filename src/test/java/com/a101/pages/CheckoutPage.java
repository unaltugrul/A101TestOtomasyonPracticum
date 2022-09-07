package com.a101.pages;

import com.a101.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@title='ÜYE OLMADAN DEVAM ET']")
    public WebElement uyeOlmadanDevamButonu;

    @FindBy(name = "user_email")
    public WebElement emailGirisKutusu;

    @FindBy(xpath = "(//a[@class='new-address js-new-address'])[1]")
    public WebElement yeniAdresOlusturLink;

    //*****Adres güncelleme kutucukları kısmı

    @FindBy(name = "title")
    public WebElement adresBasligiKutusu;

    @FindBy(name = "//input[@name='first_name']")
    public WebElement adKutusu;

    @FindBy(name = "last_name")
    public WebElement soyadKutusu;

    @FindBy(name = "phone_number")
    public WebElement telNumarasiKutusu;

    @FindBy(name = "city")
    public WebElement sehirSecimiSelectDropdown;




}
