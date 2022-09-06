Feature:Odeme Ekranına Ulasmak

  Background:
    Given Kullanici "https://www.a101.com.tr/" adresine yonlenir
    Then Kullanicinin basarili bir sekilde ana sayfaya ulasir

  @TC001
  Scenario: Kullanicinin sectigi urunun rengini dogrulamak
    Given Kullanici giyim ve aksesuar modulu uzerinde fareyi bekletir
    And Kullanici acilan menuden Kadin Ic Giyim ve Dizalti Corap kategorisine tiklar
    And Kullanici urun listesindeki ilk urunu tiklar
    Then Kullanici acilan urunun siyah oldugunu gorur













