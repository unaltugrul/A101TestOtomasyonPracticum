Feature:Kategoriden istenilen urunun secilmesi
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