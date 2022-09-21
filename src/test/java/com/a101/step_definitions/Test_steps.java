package com.a101.step_definitions;

import com.a101.pages.*;
import com.a101.utilities.BrowserUtils;
import com.a101.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;


public class Test_steps {

    HomePage homePage = new HomePage();
    DizaltiCorapPage dizaltiCorapPage = new DizaltiCorapPage();
    PenKad50DenPanCorSiyahPage penKad50DenPanCorSiyah = new PenKad50DenPanCorSiyahPage();
    SepetPage sepetPage = new SepetPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    GiyimAksesuarPage giyimAksesuarPage = new GiyimAksesuarPage();
    String eklenenUrunName;
    Faker faker = new Faker();




    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        Driver.getDriver().get(url);
    }

    @And("User accepts cookies")
    public void userAcceptsCookies() {
        try {
            homePage.cerezKabulButton.click();
        }catch (NoSuchElementException e){

        }
    }

    @Then("Verify that user lands on home page successfully")
    public void verifyThatUserLandsOnHomePageSuccessfully() {
        BrowserUtils.sleep(1);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://www.a101.com.tr/");
    }

    @Given("User hovers mouse over <giyim ve aksesuar> module")
    public void userHoversMouseOverGiyimVeAksesuarModule() {
        try {

            Actions actions1 = new Actions(Driver.getDriver());
            actions1.moveToElement(homePage.kategoriler).perform();
            BrowserUtils.sleep(1);
            Actions actions2 = new Actions(Driver.getDriver());
            actions2.moveToElement(homePage.giyimAksesuar).perform();

        }catch (Exception e){
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(homePage.giyimAksesuarModul).perform();
        }
    }

    @When("User clicks <Dizaltı Çorap> category from opened submenu")
    public void userClicksDizaltıÇorapCategoryFromOpenedSubmenu() {
        homePage.dizaltiCorap.click();
    }

    @And("User clicks first product")
    public void userClicksFirstProduct() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//div[@class='products-list']"))));
            eklenenUrunName = dizaltiCorapPage.ilkUrunLink.getAttribute("title");
            BrowserUtils.sleep(1);
            dizaltiCorapPage.ilkUrunLink.click();
        }catch (NoSuchElementException e){

        }
    }

    @Then("Verify that color is black of the product")
    public void verifyThatColorIsBlackOfTheProduct() {
        Assert.assertEquals("SİYAH",penKad50DenPanCorSiyah.renk.getText());
    }


    @And("User clicks <Sepete Ekle> button")
    public void userClicksSepeteEkleButton() {
        penKad50DenPanCorSiyah.sepeteEkleButon.click();
    }

    @When("User clicks <Sepeti Görüntüle> button")
    public void userClicksSepetiGörüntüleButton() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(penKad50DenPanCorSiyah.sepetiGoruntule));
        penKad50DenPanCorSiyah.sepetiGoruntule.click();
    }

    @Then("Verify that user can see the product in the basket")
    public void verifyThatUserCanSeeTheProductInTheBasket() {
        Assert.assertEquals(eklenenUrunName,sepetPage.eklenenUrun.getAttribute("title"));
    }
    @And("User clicks <Sepeti Onayla> button")
    public void userClicksSepetiOnaylaButton() {
        BrowserUtils.sleep(1);
        sepetPage.sepetiOnaylaButonu.click();
    }

    @And("User clicks <ÜYE OLMADAN DEVAM ET> button")
    public void userClicksÜYEOLMADANDEVAMETButton() {
        checkoutPage.uyeOlmadanDevamButonu.click();
    }
    @And("User enters email address and clicks enter key")
    public void userEntersEmailAddressAndClicksEnterKey() {
        String email = faker.internet().emailAddress();
        checkoutPage.emailGirisKutusu.sendKeys(email + Keys.ENTER);
    }

    @When("User clicks <Yeni adres oluştur> link")
    public void userClicksYeniAdresOluşturLink() {
        checkoutPage.yeniAdresOlusturLink.click();
    }

    @And("User enters required information")
    public void userEntersRequiredInformation() {
        checkoutPage.adresBasligiKutusu.sendKeys(faker.address().firstName());
        checkoutPage.adKutusu.sendKeys(faker.name().firstName());
        checkoutPage.soyadKutusu.sendKeys(faker.name().lastName());
        checkoutPage.telNumarasiKutusu.sendKeys("3126477178");

        Select select = new Select(checkoutPage.ilDropdown);
        select.selectByIndex(faker.number().numberBetween(2,82));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfAllElements(Driver.getDriver().findElement(By.xpath("//select[@name='township']//option"))));
        Select select1 = new Select(checkoutPage.ilceDropdown);
        int ilceSay= checkoutPage.ilceSayisi();
        select1.selectByIndex(faker.number().numberBetween(2,ilceSay));

        Select select2 = new Select(checkoutPage.mahDropdown);
        try {
            WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(),10);
            wait1.until(ExpectedConditions.visibilityOfAllElements(Driver.getDriver().findElement(By.xpath("//select[@name='district']//option"))));
            int mahSay = checkoutPage.mahalleSayisi();
            select2.selectByIndex(faker.number().numberBetween(2,mahSay));
        }catch (Exception e){
            int mahSay = checkoutPage.mahalleSayisi();
            select2.selectByIndex(faker.number().numberBetween(2,mahSay));
        }

        checkoutPage.adreskutusu.sendKeys(faker.address().fullAddress());

        //checkoutPage.postKodKutusu.sendKeys(faker.numerify("#####"));

    }

    @And("User clicks <Kaydet> button")
    public void userClicksKaydetButton() {

        checkoutPage.kaydetButonu.click();
    }

    @And("User selects any radio button")
    public void userSelectsAnyRadioButton() {
        BrowserUtils.sleep(2);
        checkoutPage.kargoFirButonlari.get(faker.number().numberBetween(0,checkoutPage.kargoFirButonlari.size()-1)).click();
    }

    @And("User clicks <Kaydet ve Devam Et> button")
    public void userClicksKaydetVeDevamEtButton() {
        checkoutPage.kaydetDevamEtButonu.click();
    }


    @And("User enters payment information and selects checkbox")
    public void userEntersPaymentInformationAndSelectsCheckbox() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.adSoyadKutusu));
        checkoutPage.adSoyadKutusu.sendKeys("Akbank");
        //checkoutPage.kartNumarasi.sendKeys(faker.numerify("################"));


        BrowserUtils.sleep(1);
        //checkoutPage.kartNumarasi.sendKeys(faker.numerify("4355084355084358"));

        checkoutPage.kartNumarasi.sendKeys("");
        checkoutPage.kartNumarasi.sendKeys("4");
        checkoutPage.kartNumarasi.sendKeys("3");
        checkoutPage.kartNumarasi.sendKeys("5");
        checkoutPage.kartNumarasi.sendKeys("5");

        checkoutPage.kartNumarasi.sendKeys("");
        checkoutPage.kartNumarasi.sendKeys("0");
        checkoutPage.kartNumarasi.sendKeys("8");
        checkoutPage.kartNumarasi.sendKeys("4");
        checkoutPage.kartNumarasi.sendKeys("3");

        checkoutPage.kartNumarasi.sendKeys("");
        checkoutPage.kartNumarasi.sendKeys("5");
        checkoutPage.kartNumarasi.sendKeys("5");
        checkoutPage.kartNumarasi.sendKeys("0");
        checkoutPage.kartNumarasi.sendKeys("8");

        checkoutPage.kartNumarasi.sendKeys("");
        checkoutPage.kartNumarasi.sendKeys("4");
        checkoutPage.kartNumarasi.sendKeys("3");
        checkoutPage.kartNumarasi.sendKeys("5");
        checkoutPage.kartNumarasi.sendKeys("8");


        Select select = new Select(checkoutPage.kartAyDropdown);
        //select.selectByIndex(faker.number().numberBetween(1,12));
        select.selectByValue("12");
        BrowserUtils.sleep(1);
        Select select1 = new Select(checkoutPage.kartYilDropdown);
        //select1.selectByIndex(faker.number().numberBetween(1,12));
        select1.selectByValue("2026");

        //String cvc = String.valueOf(faker.number().numberBetween(100,999));
        checkoutPage.cvcKutusu.sendKeys("000");

        WebElement element = checkoutPage.kontrolKutusu;
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", element);
        BrowserUtils.sleep(1);
    }

    @And("User clicks <Siparişi Tamamla> button")
    public void userClicksSiparişiTamamlaButton() {
        checkoutPage.sipTamamlaButonu.click();
    }

    @Then("Verify that user has been navigated to bank of page")
    public void verifyThatUserHasBeenNavigatedToBankOfPage() {

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
            wait.until(ExpectedConditions.urlMatches("https://3dsecure.akbank.com.tr/akbankacs/result.do"));
        }catch (Exception e){

        }
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Redirect Page"));
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
    }
}
