Feature:Odeme Ekranına Ulasmak

  Background:
    Given Kullanici "https://www.a101.com.tr/" adresine yonlenir
    And Kullanici cerez kullanimini kabul eder
    Then Kullanici basarili bir sekilde ana sayfaya ulasir

  @TC001
  Scenario: Kullanicinin sectigi urunun rengini dogrulamak
    Given Kullanici giyim ve aksesuar modulu uzerinde fareyi bekletir
    When Kullanici acilan menuden Kadin Ic Giyim ve Dizalti Corap kategorisine tiklar
    And Kullanici urun listesindeki ilk urunu tiklar
    Then Kullanici acilan urunun siyah oldugunu gorur

  @TC002
  Scenario: Kullanici sepete urun ekleyebildigini dogrulamak
    Given Kullanici giyim ve aksesuar modulu uzerinde fareyi bekletir
    When Kullanici acilan menuden Kadin Ic Giyim ve Dizalti Corap kategorisine tiklar
    And Kullanici urun listesindeki ilk urunu tiklar
    And Kullanici sepete ekle butonuna tiklar
    And Kullanici sepeti goruntule linkine tiklar
    Then Kullanici ekledigi urunu sepette gorur

  @TC003
  Scenario: Kullanicinin siparisi tamamlayabildigini dogrulamak
    Given Kullanici giyim ve aksesuar modulu uzerinde fareyi bekletir
    When Kullanici acilan menuden Kadin Ic Giyim ve Dizalti Corap kategorisine tiklar
    And Kullanici urun listesindeki ilk urunu tiklar
    And Kullanici sepete ekle butonuna tiklar
    When Kullanici sepeti goruntule linkine tiklar
    And Kullanici sepeti onayla butonuna basar
    And Kullanici uye olmadan devam et butonuna basar
    And Kullanici mail adresini yazar ve devam et butonuna basa
    When Kullanici yeni adres olustur linkine tiklar
    And Kullanici gerekli bilgileri kutulara isler ve kaydet butonuna basar
    And Kullanici kaydet ve devam et butonuna tiklar
    And Kullanici yanlis odeme bilgilerini girer ve siparisi tamamla butonuna basar
    Then Kullanici kart bilgilerinizi kontrol ediniz hatasini gorur

















