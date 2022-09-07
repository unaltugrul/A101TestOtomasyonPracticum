package com.a101.step_definitions;

import com.a101.pages.DizaltiCorapPage;
import com.a101.pages.HomePage;
import com.a101.pages.PenKad50DenPanCorSiyah;
import com.a101.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;


public class Odeme_ekrani_test_steps {

    HomePage homePage = new HomePage();
    DizaltiCorapPage dizaltiCorapPage = new DizaltiCorapPage();
    PenKad50DenPanCorSiyah penKad50DenPanCorSiyah = new PenKad50DenPanCorSiyah();


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

    @And("Kullanici beliren popup pencereyi kapatir")
    public void kullanici_beliren_popup_pencereyi_kapatir() {
        try {
            homePage.popupClose.click();
        }catch (Exception e){
            System.out.println("pop-up gosterilmedi");
        }

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
        dizaltiCorapPage.ilkUrunLink.click();
    }
    @Then("Kullanici acilan urunun siyah oldugunu gorur")
    public void kullanici_acilan_urunun_siyah_oldugunu_gorur() {
        Assert.assertEquals("SİYAH",penKad50DenPanCorSiyah.renk.getText());
    }


}
