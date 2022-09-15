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
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @Then("Verify that user should be able to land on home page")
    public void verifyThatUserShouldBeAbleToLandOnHomePage() {
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



    @When("Kullanici sepete ekle butonuna tiklar")
    public void kullanici_sepete_ekle_butonuna_tiklar() {
        penKad50DenPanCorSiyah.sepeteEkleButon.click();
    }

    @When("Kullanici sepeti goruntule linkine tiklar")
    public void kullanici_sepeti_goruntule_linkine_tiklar() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(penKad50DenPanCorSiyah.sepetiGoruntule));
        penKad50DenPanCorSiyah.sepetiGoruntule.click();
    }

    @Then("Kullanici ekledigi urunu sepette gorur")
    public void kullanici_ekledigi_urunu_sepette_gorur() {
        Assert.assertEquals(eklenenUrunName,sepetPage.eklenenUrun.getAttribute("title"));
    }

    @When("Kullanici sepeti onayla butonuna basar")
    public void kullanici_sepeti_onayla_butonuna_basar() {
        BrowserUtils.sleep(1);
        sepetPage.sepetiOnaylaButonu.click();
    }
    @When("Kullanici uye olmadan devam et butonuna basar")
    public void kullanici_uye_olmadan_devam_et_butonuna_basar() {
        checkoutPage.uyeOlmadanDevamButonu.click();
    }
    @And("Kullanici mail adresini yazar enter tusuna basar")
    public void kullaniciMailAdresiniYazarEnterTusunaBasar() {
        String email = faker.internet().emailAddress();
        checkoutPage.emailGirisKutusu.sendKeys(email + Keys.ENTER);
    }
    @When("Kullanici yeni adres olustur linkine tiklar")
    public void kullanici_yeni_adres_olustur_linkine_tiklar() {
        checkoutPage.yeniAdresOlusturLink.click();
    }
    @When("Kullanici adres basligi girer")
    public void kullanici_adres_basligi_girer() {
        checkoutPage.adresBasligiKutusu.sendKeys(faker.address().firstName());
    }
    @When("Kullanici adini girer")
    public void kullanici_adini_girer() {
        checkoutPage.adKutusu.sendKeys(faker.name().firstName());
    }
    @When("Kullanici Soyadini girer")
    public void kullanici_soyadini_girer() {
        checkoutPage.soyadKutusu.sendKeys(faker.name().lastName());
    }
    @When("Kullanici cep telefon numarasini girer")
    public void kullanici_cep_telefon_numarasini_girer() {
        checkoutPage.telNumarasiKutusu.sendKeys("3126477178");
    }
    @When("Kullanici il secer")
    public void kullanici_il_secer() {
        Select select = new Select(checkoutPage.ilDropdown);
        select.selectByIndex(faker.number().numberBetween(2,82));
    }
    @When("Kullanici ilce secer")
    public void kullanici_ilce_secer() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfAllElements(Driver.getDriver().findElement(By.xpath("//select[@name='township']//option"))));
        Select select1 = new Select(checkoutPage.ilceDropdown);
        int ilceSay= checkoutPage.ilceSayisi();
        select1.selectByIndex(faker.number().numberBetween(2,ilceSay));

    }
    @When("Kullanici mahalle secer")
    public void kullanici_mahalle_secer() {
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
    }
    @When("Kullanici adres girer")
    public void kullanici_adres_girer() {
        checkoutPage.adreskutusu.sendKeys(faker.address().fullAddress());
    }
    @When("Kullanici posta kodu girer")
    public void kullanici_posta_kodu_girer() {
        checkoutPage.postKodKutusu.sendKeys(faker.numerify("#####"));
    }

    @When("Kullanici kaydet butonuna basar")
    public void kullanici_kaydet_butonuna_basar() {
        checkoutPage.kaydetButonu.click();
    }

    @And("Kullanici kargo firmasi secer")
    public void kullaniciKargoFirmasiSecer() {
        BrowserUtils.sleep(2);
        checkoutPage.kargoFirButonlari.get(faker.number().numberBetween(0,checkoutPage.kargoFirButonlari.size()-1)).click();
    }

    @When("Kullanici kaydet ve devam et butonuna tiklar")
    public void kullanici_kaydet_ve_devam_et_butonuna_tiklar() {
        checkoutPage.kaydetDevamEtButonu.click();
    }

    @And("Kullanici odeme bilgilerini girer ve sozlesmeyi kabul eder")
    public void kullaniciOdemeBilgileriniGirerVeSozlesmeyiKabulEder() {
        checkoutPage.adSoyadKutusu.sendKeys(faker.name().name() + " " + faker.name().lastName());
        checkoutPage.kartNumarasi.sendKeys(faker.numerify("################"));
        Select select = new Select(checkoutPage.kartAyDropdown);
        select.selectByIndex(faker.number().numberBetween(1,12));

        Select select1 = new Select(checkoutPage.kartYilDropdown);
        select1.selectByIndex(faker.number().numberBetween(1,12));

        String cvc = String.valueOf(faker.number().numberBetween(100,999));
        checkoutPage.cvcKutusu.sendKeys(cvc);

        WebElement element = checkoutPage.kontrolKutusu;
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", element);
        BrowserUtils.sleep(1);

    }

    @And("Kullanici siparisi tamamla butonuna basar")
    public void kullaniciSiparisiTamamlaButonunaBasar() {
        checkoutPage.sipTamamlaButonu.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.spinner));
    }

    @Then("Kullanici hata mesajini gorur")
    public void kullaniciHataMesajiniGorur() {

        try {
            Assert.assertTrue(checkoutPage.error1.isDisplayed());
        }catch (Exception e){
            Assert.assertTrue(checkoutPage.error2.isDisplayed());
        }


    }



}
