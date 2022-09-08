package com.a101.step_definitions;

import com.a101.pages.*;
import com.a101.utilities.BrowserUtils;
import com.a101.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Odeme_ekrani_test_steps {

    HomePage homePage = new HomePage();
    DizaltiCorapPage dizaltiCorapPage = new DizaltiCorapPage();
    PenKad50DenPanCorSiyahPage penKad50DenPanCorSiyah = new PenKad50DenPanCorSiyahPage();
    SepetPage sepetPage = new SepetPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    String eklenenUrunName;
    Faker faker = new Faker();

    @Given("Kullanici {string} adresine yonlenir")
    public void kullanici_adresine_yonlenir(String url) {
        Driver.getDriver().get(url);
    }

    @Then("Kullanici basarili bir sekilde ana sayfaya ulasir")
    public void kullanici_basarili_bir_sekilde_ana_sayfaya_ulasir() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://www.a101.com.tr/");
    }

    @And("Kullanici cerez kullanimini kabul eder")
    public void kullanici_cerez_kullanimini_kabul_eder() {
        homePage.cerezKabulButton.click();
    }

    @Given("Kullanici giyim ve aksesuar modulu uzerinde fareyi bekletir")
    public void kullanici_giyim_ve_aksesuar_modulu_uzerinde_fareyi_bekletir() {
        try {
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(homePage.giyimAksesuarModul).perform();
        }catch (ElementNotInteractableException e){
            System.out.println("Farklı arayüz kullanılmaya başlandı...");
            Actions actions1 = new Actions(Driver.getDriver());
            actions1.moveToElement(homePage.kategoriler).perform();
            actions1.moveToElement(homePage.giyimAksesuar).perform();

        }

    }

    @Given("Kullanici acilan menuden Kadin Ic Giyim ve Dizalti Corap kategorisine tiklar")
    public void kullanici_acilan_menuden_kadin_ic_giyim_ve_dizalti_corap_kategorisine_tiklar() {
        homePage.dizaltiCorap.click();
    }

    @Given("Kullanici urun listesindeki ilk urunu tiklar")
    public void kullanici_urun_listesindeki_ilk_urunu_tiklar() {
        BrowserUtils.sleep(1);
        eklenenUrunName = dizaltiCorapPage.ilkUrunLink.getAttribute("title");
        dizaltiCorapPage.ilkUrunLink.click();
    }

    @Then("Kullanici acilan urunun siyah oldugunu gorur")
    public void kullanici_acilan_urunun_siyah_oldugunu_gorur() {
        Assert.assertEquals("SİYAH",penKad50DenPanCorSiyah.renk.getText());
    }

    @When("Kullanici sepete ekle butonuna tiklar")
    public void kullanici_sepete_ekle_butonuna_tiklar() {
        penKad50DenPanCorSiyah.sepeteEkleButon.click();
    }

    @When("Kullanici sepeti goruntule linkine tiklar")
    public void kullanici_sepeti_goruntule_linkine_tiklar() {
        BrowserUtils.sleep(1);
        penKad50DenPanCorSiyah.sepetiGoruntule.click();
    }

    @Then("Kullanici ekledigi urunu sepette gorur")
    public void kullanici_ekledigi_urunu_sepette_gorur() {
        Assert.assertEquals(eklenenUrunName,sepetPage.eklenenUrun.getAttribute("title"));
    }

    @When("Kullanici sepeti onayla butonuna basar")
    public void kullanici_sepeti_onayla_butonuna_basar() {
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
    @When("Kullanici kaydet butonuna basar")
    public void kullanici_kaydet_butonuna_basar() {
        checkoutPage.adresBasligiKutusu.sendKeys(faker.address().firstName());
        checkoutPage.adKutusu.sendKeys(faker.name().firstName());
        checkoutPage.soyadKutusu.sendKeys(faker.name().lastName());
        checkoutPage.telNumarasiKutusu.sendKeys(faker.numerify("###-###-####"));

        Select select = new Select(checkoutPage.ilDropdown);
        select.selectByIndex(faker.number().numberBetween(2,82));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//select[@name='township']//option[2]"))));

        Select select1 = new Select(checkoutPage.ilceDropdown);
        int ilceSay= checkoutPage.ilceSayisi();
        System.out.println("ilceSay = " + ilceSay);
        select1.selectByIndex(faker.number().numberBetween(2,ilceSay));

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(),10);
        wait1.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//select[@name='district']//option[2]"))));

        Select select2 = new Select(checkoutPage.mahDropdown);
        int mahSay = checkoutPage.mahalleSayisi();
        System.out.println("mahSay = " + mahSay);
        select2.selectByIndex(faker.number().numberBetween(2,mahSay));



        checkoutPage.adreskutusu.sendKeys(faker.address().fullAddress());
        BrowserUtils.sleep(1);
        checkoutPage.postKodKutusu.sendKeys(faker.numerify("#####"));
        BrowserUtils.sleep(1);
        checkoutPage.kaydetButonu.click();
    }

    @And("Kullanici kargo firmasi secer")
    public void kullaniciKargoFirmasiSecer() {
    }

    @When("Kullanici kaydet ve devam et butonuna tiklar")
    public void kullanici_kaydet_ve_devam_et_butonuna_tiklar() {

    }
    @When("Kullanici yanlis odeme bilgilerini girer ve siparisi tamamla butonuna basar")
    public void kullanici_yanlis_odeme_bilgilerini_girer_ve_siparisi_tamamla_butonuna_basar() {

    }
    @Then("Kullanici kart bilgilerinizi kontrol ediniz mesajini gorur")
    public void kullanici_kart_bilgilerinizi_kontrol_ediniz_mesajini_gorur() {

    }



}
