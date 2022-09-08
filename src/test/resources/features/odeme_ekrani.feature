Feature:Odeme Ekranına Ulasmak

  Background:
    Given Kullanici "https://www.a101.com.tr/" adresine yonlenir
    And Kullanici cerez kullanimini kabul eder
    Then Kullanici basarili bir sekilde ana sayfaya ulasir

  @TC003
  Scenario: Kullanicinin siparisi tamamlayabildigini dogrulamak
    Given Kullanici giyim ve aksesuar modulu uzerinde fareyi bekletir
    When Kullanici acilan menuden Kadin Ic Giyim ve Dizalti Corap kategorisine tiklar
    And Kullanici urun listesindeki ilk urunu tiklar
    And Kullanici sepete ekle butonuna tiklar
    When Kullanici sepeti goruntule linkine tiklar
    And Kullanici sepeti onayla butonuna basar
    And Kullanici uye olmadan devam et butonuna basar
    And Kullanici mail adresini yazar enter tusuna basar
    When Kullanici yeni adres olustur linkine tiklar
    And Kullanici adres basligi girer
    And Kullanici adini girer
    And Kullanici Soyadini girer
    And Kullanici cep telefon numarasini girer
    And Kullanici il secer
    And Kullanici ilce secer
    And Kullanici mahalle secer
    And Kullanici adres girer
    And Kullanici posta kodu girer
    And Kullanici kaydet butonuna basar
    And Kullanici kargo firmasi secer
    And Kullanici kaydet ve devam et butonuna tiklar
    And Kullanici yanlis odeme bilgilerini girer ve sozlesmeyi kabul eder
    And Kullanici siparisi tamamla butonuna basar
    Then Kullanici kart bilgilerinizi kontrol ediniz mesajini gorur

















