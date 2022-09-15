Feature:
  Background:
    Given User navigates to "https://www.a101.com.tr/"
    And User accepts cookies
    Then Verify that user should be able to land on home page

  @TC001
  Scenario: Kullanicinin sectigi urunun rengini dogrulamak
    Given Kullanici giyim ve aksesuar modulu uzerinde fareyi bekletir
    When Kullanici acilan menuden Dizalti Corap kategorisine tiklar
    And Kullanici urun listesindeki ilk urunu tiklar
    Then Kullanici acilan urunun siyah oldugunu gorur

