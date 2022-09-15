Feature:

  Background:
    Given User navigates to "https://www.a101.com.tr/"
    And User accepts cookies
    Then Verify that user should be able to land on home page

  @TC002
  Scenario: Kullanici sepete urun ekleyebildigini dogrulamak
    Given Kullanici giyim ve aksesuar modulu uzerinde fareyi bekletir
    When Kullanici acilan menuden Dizalti Corap kategorisine tiklar
    And Kullanici urun listesindeki ilk urunu tiklar
    And Kullanici sepete ekle butonuna tiklar
    And Kullanici sepeti goruntule linkine tiklar
    Then Kullanici ekledigi urunu sepette gorur
