package com.a101.step_definitions;

import com.a101.pages.DizaltiCorapPage;
import com.a101.pages.HomePage;
import com.a101.pages.PenKad50DenPanCorSiyahPage;
import com.a101.pages.SepetPage;
import com.a101.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;


public class Odeme_ekrani_test_steps {

    HomePage homePage = new HomePage();
    DizaltiCorapPage dizaltiCorapPage = new DizaltiCorapPage();
    PenKad50DenPanCorSiyahPage penKad50DenPanCorSiyah = new PenKad50DenPanCorSiyahPage();
    SepetPage sepetPage = new SepetPage();
    String eklenenUrunName;

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
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.giyimAksesuarModul).perform();
    }

    @Given("Kullanici acilan menuden Kadin Ic Giyim ve Dizalti Corap kategorisine tiklar")
    public void kullanici_acilan_menuden_kadin_ic_giyim_ve_dizalti_corap_kategorisine_tiklar() {
        homePage.dizaltiCorap.click();
    }

    @Given("Kullanici urun listesindeki ilk urunu tiklar")
    public void kullanici_urun_listesindeki_ilk_urunu_tiklar() {
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
        penKad50DenPanCorSiyah.sepetiGoruntule.click();
    }

    @Then("Kullanici ekledigi urunu sepette gorur")
    public void kullanici_ekledigi_urunu_sepette_gorur() {

    }

    @When("Kullanici sepeti onayla butonuna basar")
    public void kullanici_sepeti_onayla_butonuna_basar() {

    }
    @When("Kullanici uye olmadan devam et butonuna basar")
    public void kullanici_uye_olmadan_devam_et_butonuna_basar() {

    }
    @When("Kullanici mail adresini yazar ve devam et butonuna basa")
    public void kullanici_mail_adresini_yazar_ve_devam_et_butonuna_basa() {

    }
    @When("Kullanici yeni adres olustur linkine tiklar")
    public void kullanici_yeni_adres_olustur_linkine_tiklar() {

    }
    @When("Kullanici gerekli bilgileri kutulara isler ve kaydet butonuna basar")
    public void kullanici_gerekli_bilgileri_kutulara_isler_ve_kaydet_butonuna_basar() {

    }
    @When("Kullanici kaydet ve devam et butonuna tiklar")
    public void kullanici_kaydet_ve_devam_et_butonuna_tiklar() {

    }
    @When("Kullanici yanlis odeme bilgilerini girer ve siparisi tamamla butonuna basar")
    public void kullanici_yanlis_odeme_bilgilerini_girer_ve_siparisi_tamamla_butonuna_basar() {

    }
    @Then("Kullanici kart bilgilerinizi kontrol ediniz hatasini gorur")
    public void kullanici_kart_bilgilerinizi_kontrol_ediniz_hatasini_gorur() {

    }


}
