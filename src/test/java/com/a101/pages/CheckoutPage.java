package com.a101.pages;

import com.a101.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(name = "first_name")
    public WebElement adKutusu;

    @FindBy(name = "last_name")
    public WebElement soyadKutusu;

    @FindBy(name = "phone_number")
    public WebElement telNumarasiKutusu;

    @FindBy(xpath = "//select[@name='city']")
    public WebElement ilDropdown;

    @FindBy(xpath = "//select[@name='township']")
    public WebElement ilceDropdown;

    @FindBy(xpath = "//select[@name='district']")
    public WebElement mahDropdown;

    @FindBy(name = "line")
    public WebElement adreskutusu;

    @FindBy(name = "postcode")
    public WebElement postKodKutusu;

    //ilçe sayısı bulmak için bu metodu kullanacağım

    public int ilceSayisi(){
        List<WebElement> ilceler = Driver.getDriver().findElements(By.xpath("//select[@name='township']//option"));
        return ilceler.size();
    }

    //Mahalle sayısını bulmak için bu metodu kullanacağım
    public int mahalleSayisi(){
        List<WebElement> mahalleler = Driver.getDriver().findElements(By.xpath("//select[@name='district']//option"));
        return mahalleler.size();
    }

    //************** Kargo bilgileri kısmı

    @FindBy(xpath = "//button[@class='button green js-set-country js-prevent-emoji']")
    public WebElement kaydetButonu;

    @FindBy(xpath = "//ul[@class='js-shipping-list']//div[@class='check']")
    public List<WebElement> kargoFirButonlari;

    @FindBy(xpath = "//button[@class='button block green js-proceed-button']")
    public WebElement kaydetDevamEtButonu;

    //****************Ödeme ekranı
    @FindBy(xpath = "(//input[@name='name'])[2]")
    public WebElement adSoyadKutusu;

    @FindBy(xpath = "//input[@class='js-masterpassbin-payment-card']")
    public WebElement kartNumarasi;

    @FindBy(xpath = "(//select[@name='card_month'])[2]")
    public WebElement kartAyDropdown;

    @FindBy(xpath = "(//select[@name='card_year'])[2]")
    public WebElement kartYilDropdown;

    @FindBy(xpath = "(//input[@name='card_cvv'])[2]")
    public WebElement cvcKutusu;

    @FindBy(id = "agrement2")
    public WebElement kontrolKutusu;

    @FindBy(xpath = "(//button[@class='button block green continue-button'])[2]")
    public WebElement sipTamamlaButonu;










}
